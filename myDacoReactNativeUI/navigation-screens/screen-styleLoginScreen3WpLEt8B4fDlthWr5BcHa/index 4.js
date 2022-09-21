import React, { useState, useRef, useEffect, createRef } from "react";
import { View, Text, Image, ScrollView, SafeAreaView, TextInput, StyleSheet, Animated, Dimensions, Vibration, Alert, ActivityIndicator, KeyboardAvoidingView, TouchableWithoutFeedback, TouchableOpacity, Platform} from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { Svg, Path } from "react-native-svg"
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createStackNavigator } from '@react-navigation/stack';
import AnimatedSplash from "react-native-animated-splash-screen";
import { Page_styleLoginScreen3WpLEt8B4fDlthWr5BcHa } from "../../pages/Page_styleLoginScreen3WpLEt8B4fDlthWr5BcHa";
const styleLoginScreen3WpLEt8B4fDlthWr5BcHaStackNavigator = createStackNavigator();
export const ScreenForstyleLoginScreen3WpLEt8B4fDlthWr5BcHa = ({ navigation }) => {
	return (
		<styleLoginScreen3WpLEt8B4fDlthWr5BcHaStackNavigator.Navigator>
			<styleLoginScreen3WpLEt8B4fDlthWr5BcHaStackNavigator.Screen
				name = "styleLoginScreen3WpLEt8B4fDlthWr5BcHa"
				component = {Page_styleLoginScreen3WpLEt8B4fDlthWr5BcHa}
				options = {{
					headerShown: false
				}}
			/>
		</styleLoginScreen3WpLEt8B4fDlthWr5BcHaStackNavigator.Navigator>
	)
};
