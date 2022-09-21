import React, { createContext, useState, useContext, useEffect } from 'react';
import AsyncStorage from '@react-native-community/async-storage';
import { useToast } from "react-native-toast-notifications";
import { dataApi } from '../../shared/api';

const AuthContext = createContext({});

export const AuthProvider = ({children}) => {
  const [authData, setAuthData] = useState();
  const toast = useToast();
  
  //The loading part will be explained in the persist step session
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    loadStorageData();
  }, []);
  async function loadStorageData() {
    try {
      //Try get the data from Async Storage
      const authDataSerialized = await AsyncStorage.getItem('@AuthData');
      if (authDataSerialized) {
        //If there are data, it's converted to an Object and the state is updated.
        const _authData = JSON.parse(authDataSerialized);
        setAuthData(_authData);
      }
    } catch (error) {
    } finally {
      //loading finished
      setLoading(false);
    }
  }
  const signIn = async ({ storageId, ...rest }) => {
    //call the service passing credential (email and password).
    //In a real App this data will be provided by the user from some InputText components.
    const _authData = await dataApi.signIn({
      storageId,
      ...rest,
    });

    if (_authData.result) {
      const userData = await dataApi.retrieveUser({ storageId, tokenId: _authData.data.token });      setAuthData({ email: rest.primary_key, token: _authData.data.token, ...userData.data.values });
        AsyncStorage.setItem('@AuthData', JSON.stringify({ email: rest.primary_key, token: _authData.data.token, }))
      } else {
        toast.show(_authData.data.detail, {
          type: "danger",
          placement: "top",
          duration: 4000,
          offset: 30,
          animationType: "slide-in",
        });
      }  };

  const resetPassword = async ({ storageId, ...rest }) => {
    //call the service passing credential (email and password).
    //In a real App this data will be provided by the user from some InputText components.
    await dataApi.resetPassword({
      storageId,
      ...rest,
    });
    toast.show("New password was sent to your email", {
      type: "success",
      placement: "top",
      duration: 4000,
      offset: 30,
      animationType: "slide-in",
    });
  };

  const signUp = async ({ storageId, ...rest }) => {
    const _authData = await dataApi.signUp({
      storageId,
      ...rest,
    });

    if (_authData.result) {
      const signInData = await dataApi.signIn({
        storageId,
        "primary_key": rest[_authData.data.primary_key._id],
        "password": rest[_authData.data.password_key._id],
      });

      if (signInData.result) {
        const userData = await dataApi.retrieveUser({ storageId, tokenId: signInData.data.token });        setAuthData({ email: _authData.data.primary_key._id, token: signInData.data.token, ...userData.data.values});
        AsyncStorage.setItem('@AuthData', JSON.stringify({ email: _authData.data.primary_key._id, token: signInData.data.token, }));
        toast.show("Successful registration", {
          type: "success",
          placement: "top",
          duration: 4000,
          offset: 30,
          animationType: "slide-in",
        });
      } else {
        toast.show("Something went wrong", {
          type: "danger",
          placement: "top",
          duration: 4000,
          offset: 30,
          animationType: "slide-in",
        });
      }
    } else {
      toast.show(_authData.data.detail, {        type: "danger",
        placement: "top",
        duration: 4000,
        offset: 30,
        animationType: "slide-in",
      });
    };
  };
  const signOut = async () => {
    //Remove data from context, so the App can be notified
    //and send the user to the AuthStack
    setAuthData(undefined);
    await AsyncStorage.removeItem('@AuthData');
  };

  return (
    //This component will be used to encapsulate the whole App,
    //so all components will have access to the Context
    <AuthContext.Provider value={{authData, loading, signIn, signOut, signUp, resetPassword}}>
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => {
  const context = useContext(AuthContext);

  if (!context) {
    throw new Error('useAuth must be used within an AuthProvider');
  }

  return context;
}