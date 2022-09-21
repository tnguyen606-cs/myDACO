import React, { useState, useRef, useEffect, createRef } from "react";
import { View, Text, Image, ScrollView, SafeAreaView, TextInput, StyleSheet, Animated, Dimensions, Vibration, Alert, ActivityIndicator, KeyboardAvoidingView, TouchableWithoutFeedback, TouchableOpacity, Platform} from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { Svg, Path } from "react-native-svg"
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createStackNavigator } from '@react-navigation/stack';
import AnimatedSplash from "react-native-animated-splash-screen";
import { Page_styleForgotPasswordScreen } from "../../pages/Page_styleForgotPasswordScreen";
const styleForgotPasswordScreenStackNavigator = createStackNavigator();
export const ScreenForstyleForgotPasswordScreen = ({ navigation }) => {
	return (
		<styleForgotPasswordScreenStackNavigator.Navigator>
			<styleForgotPasswordScreenStackNavigator.Screen
				name = "styleForgotPasswordScreen"
				component = {Page_styleForgotPasswordScreen}
				options = {{
					headerShown: false
				}}
			/>
		</styleForgotPasswordScreenStackNavigator.Navigator>
	)
};
