import React, { useState, useRef, useEffect, createRef } from "react";
import { View, Text, Image, ScrollView, SafeAreaView, TextInput, StyleSheet, Animated, Dimensions, Vibration, Alert, ActivityIndicator, KeyboardAvoidingView, TouchableWithoutFeedback, TouchableOpacity, Platform} from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { Svg, Path } from "react-native-svg"
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createStackNavigator } from '@react-navigation/stack';
import AnimatedSplash from "react-native-animated-splash-screen";
import { Page_styleLoadingBar01 } from "../../pages/Page_styleLoadingBar01";
const styleLoadingBar01StackNavigator = createStackNavigator();
export const ScreenForstyleLoadingBar01 = ({ navigation }) => {
	return (
		<styleLoadingBar01StackNavigator.Navigator>
			<styleLoadingBar01StackNavigator.Screen
				name = "styleLoadingBar01"
				component = {Page_styleLoadingBar01}
				options = {{
					headerShown: false
				}}
			/>
		</styleLoadingBar01StackNavigator.Navigator>
	)
};
