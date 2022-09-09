import React, { useState, useRef, useEffect, createRef } from "react";
import { View, Text, Image, ScrollView, SafeAreaView, TextInput, StyleSheet, Animated, Dimensions, Vibration, Alert, ActivityIndicator, KeyboardAvoidingView, TouchableWithoutFeedback, TouchableOpacity, Platform} from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { Svg, Path } from "react-native-svg"
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createStackNavigator } from '@react-navigation/stack';
import AnimatedSplash from "react-native-animated-splash-screen";
import { ToastProvider } from 'react-native-toast-notifications'
import { useFonts } from 'expo-font';
import { SplashPage } from "./utils/splash";
import { AuthProvider, useAuth } from "./entities/auth";
import { ScreenForstyleLoginScreen } from "./navigation-screens/screen-styleLoginScreen";
import { ScreenForstyleMainMenuScreen } from "./navigation-screens/screen-styleMainMenuScreen";
import { ScreenForstyleBumpPlanScreen } from "./navigation-screens/screen-styleBumpPlanScreen";
import { ScreenForstyleManifestModificationScreen } from "./navigation-screens/screen-styleManifestModificationScreen";
import { ScreenForstyleSearchAirfieldScreen } from "./navigation-screens/screen-styleSearchAirfieldScreen";
import { ScreenForstyleSearchingForJ } from "./navigation-screens/screen-styleSearchingForJ";
import { ScreenForstyleSearchAirfieldScreenyAy_OzbOprJFpg_YxsiA2 } from "./navigation-screens/screen-styleSearchAirfieldScreenyAy_OzbOprJFpg_YxsiA2";
import { ScreenForstyleTransfer } from "./navigation-screens/screen-styleTransfer";
import { ScreenForstyleRemove } from "./navigation-screens/screen-styleRemove";
import { ScreenForstyleRemoveLoadPersonnelOverlay } from "./navigation-screens/screen-styleRemoveLoadPersonnelOverlay";
import { ScreenForstyleTransferLoadPersonnelOverla } from "./navigation-screens/screen-styleTransferLoadPersonnelOverla";
import { ScreenForstyleRemovalSuccessOverlay } from "./navigation-screens/screen-styleRemovalSuccessOverlay";
import { ScreenForstyleTransferSuccessOverlay } from "./navigation-screens/screen-styleTransferSuccessOverlay";
import { ScreenForstyleInoperablePlaneUi } from "./navigation-screens/screen-styleInoperablePlaneUi";
import { ScreenForstyleLoadingBar04 } from "./navigation-screens/screen-styleLoadingBar04";
import { ScreenForstyleLoadingBar03 } from "./navigation-screens/screen-styleLoadingBar03";
import { ScreenForstyleLoadingBar02 } from "./navigation-screens/screen-styleLoadingBar02";
import { ScreenForstyleLoadingBar01 } from "./navigation-screens/screen-styleLoadingBar01";
import { ScreenForstyleMenuDropdown } from "./navigation-screens/screen-styleMenuDropdown";
import { ScreenForstyleMainMenuScreenBeforeBump_ } from "./navigation-screens/screen-styleMainMenuScreenBeforeBump_";
import { ScreenForstyleMainMenuScreenAfterBump_ } from "./navigation-screens/screen-styleMainMenuScreenAfterBump_";
import { ScreenForstyleMainMenuScreenAfterBumpA } from "./navigation-screens/screen-styleMainMenuScreenAfterBumpA";
import { ScreenForstyleCaptainJacobBarrett } from "./navigation-screens/screen-styleCaptainJacobBarrett";
import { ScreenForstyleHelpDocumentationScreen } from "./navigation-screens/screen-styleHelpDocumentationScreen";
import { ScreenForstyleManifestModificationScreen_ } from "./navigation-screens/screen-styleManifestModificationScreen_";
import { ScreenForstyleManifestModificationScreen_R_jBcGplYZaC9ejrfu6mJ } from "./navigation-screens/screen-styleManifestModificationScreen_R_jBcGplYZaC9ejrfu6mJ";
import { ScreenForstyleHistory1 } from "./navigation-screens/screen-styleHistory1";
import { ScreenForstyleHistory2 } from "./navigation-screens/screen-styleHistory2";
import { ScreenForstyleSignUpScreen } from "./navigation-screens/screen-styleSignUpScreen";
import { ScreenForstyleForgotPasswordScreen } from "./navigation-screens/screen-styleForgotPasswordScreen";
import { ScreenForstyleLoginScreen3WpLEt8B4fDlthWr5BcHa } from "./navigation-screens/screen-styleLoginScreen3WpLEt8B4fDlthWr5BcHa";
const Tab = createBottomTabNavigator();
function Router () {
	let [fontsLoaded] = useFonts({
	});
	const [focus0, setFocus0] = useState(false);
	const { authData, loading } = useAuth();
	const [loaded, setLoaded] = useState(false);

	useEffect(() => {
		setTimeout(setLoaded, 1000, true);
	}, [fontsLoaded]);
	const Stack = createStackNavigator();
	if (loading){
		return null
	}
	return (
	  <AnimatedSplash
   translucent={true} // When translucent is set to true, the app will draw under the status bar
   //backgroundColor={"red"} // Splash screen background color. def: '#f00'
   isLoaded={loaded} //Condition to show children component and finish the animation.
   //logoHeight={300} //Logo image height in px.
   //logoWidth={300} //Logo image width in px.
   //logoImage={{ // logo link
    //uri: "https://www.logodesignlove.com/wp-content/uploads/2022/01/logo-wave-symbol-01.jpg",
   //}}
   customComponent={<SplashPage />} // Add a logo component instead of a logo image. (React Component)
  >
	<NavigationContainer>
		<Tab.Navigator 
			initialRouteName = {"styleLoginScreen"}
			tabBarOptions={{
				showLabel: false,
				activeTintColor: '#e91e63',
				inactiveTintColor: 'green',
				activeBackgroundColor: 'yellow',
				style: {position: "absolute", bottom: 0, left: 0, right: 0, width: 0, height: 0},
			}}
		>
			{ (authData?.token ) && <Tab.Screen name = "styleLoginScreen" component = {ScreenForstyleLoginScreen} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleMainMenuScreen" component = {ScreenForstyleMainMenuScreen} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleBumpPlanScreen" component = {ScreenForstyleBumpPlanScreen} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleManifestModificationScreen" component = {ScreenForstyleManifestModificationScreen} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleSearchAirfieldScreen" component = {ScreenForstyleSearchAirfieldScreen} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleSearchingForJ" component = {ScreenForstyleSearchingForJ} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleSearchAirfieldScreenyAy_OzbOprJFpg_YxsiA2" component = {ScreenForstyleSearchAirfieldScreenyAy_OzbOprJFpg_YxsiA2} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleTransfer" component = {ScreenForstyleTransfer} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleRemove" component = {ScreenForstyleRemove} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleRemoveLoadPersonnelOverlay" component = {ScreenForstyleRemoveLoadPersonnelOverlay} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleTransferLoadPersonnelOverla" component = {ScreenForstyleTransferLoadPersonnelOverla} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleRemovalSuccessOverlay" component = {ScreenForstyleRemovalSuccessOverlay} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleTransferSuccessOverlay" component = {ScreenForstyleTransferSuccessOverlay} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleInoperablePlaneUi" component = {ScreenForstyleInoperablePlaneUi} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleLoadingBar04" component = {ScreenForstyleLoadingBar04} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleLoadingBar03" component = {ScreenForstyleLoadingBar03} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleLoadingBar02" component = {ScreenForstyleLoadingBar02} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleLoadingBar01" component = {ScreenForstyleLoadingBar01} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleMenuDropdown" component = {ScreenForstyleMenuDropdown} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleMainMenuScreenBeforeBump_" component = {ScreenForstyleMainMenuScreenBeforeBump_} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleMainMenuScreenAfterBump_" component = {ScreenForstyleMainMenuScreenAfterBump_} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleMainMenuScreenAfterBumpA" component = {ScreenForstyleMainMenuScreenAfterBumpA} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleCaptainJacobBarrett" component = {ScreenForstyleCaptainJacobBarrett} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleHelpDocumentationScreen" component = {ScreenForstyleHelpDocumentationScreen} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleManifestModificationScreen_" component = {ScreenForstyleManifestModificationScreen_} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleManifestModificationScreen_R_jBcGplYZaC9ejrfu6mJ" component = {ScreenForstyleManifestModificationScreen_R_jBcGplYZaC9ejrfu6mJ} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleHistory1" component = {ScreenForstyleHistory1} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleHistory2" component = {ScreenForstyleHistory2} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleSignUpScreen" component = {ScreenForstyleSignUpScreen} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleForgotPasswordScreen" component = {ScreenForstyleForgotPasswordScreen} /> }
			{ (authData?.token ) && <Tab.Screen name = "styleLoginScreen3WpLEt8B4fDlthWr5BcHa" component = {ScreenForstyleLoginScreen3WpLEt8B4fDlthWr5BcHa} /> }
		</Tab.Navigator>
	</NavigationContainer>
	</AnimatedSplash>
	)
}
export default function App () {
	return (
		<ToastProvider>
			<AuthProvider>
				<Router/>
			</AuthProvider>
		</ToastProvider>
	)
}