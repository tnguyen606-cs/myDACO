import React, { useState, useRef, useEffect, createRef } from "react";
import { View, Text, Image, ScrollView, SafeAreaView, TextInput, StyleSheet, Animated, Dimensions, Vibration, Alert, ActivityIndicator, KeyboardAvoidingView, TouchableWithoutFeedback, TouchableOpacity, Platform} from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { Svg, Path } from "react-native-svg"
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createStackNavigator } from '@react-navigation/stack';
import AnimatedSplash from "react-native-animated-splash-screen";
import { Page_styleSearchAirfieldScreen } from "../../pages/Page_styleSearchAirfieldScreen";
const styleSearchAirfieldScreenStackNavigator = createStackNavigator();
export const ScreenForstyleSearchAirfieldScreen = ({ navigation }) => {
	return (
		<styleSearchAirfieldScreenStackNavigator.Navigator>
			<styleSearchAirfieldScreenStackNavigator.Screen
				name = "styleSearchAirfieldScreen"
				component = {Page_styleSearchAirfieldScreen}
				options = {{
					headerShown: false
				}}
			/>
		</styleSearchAirfieldScreenStackNavigator.Navigator>
	)
};