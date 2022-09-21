import React, { useState, useRef, useEffect, createRef } from "react";
import { View, Text, Image, ScrollView, SafeAreaView, TextInput, StyleSheet, Animated, Dimensions, Vibration, Alert, ActivityIndicator, KeyboardAvoidingView, TouchableWithoutFeedback, TouchableOpacity, Platform} from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { Svg, Path } from "react-native-svg"
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createStackNavigator } from '@react-navigation/stack';
import AnimatedSplash from "react-native-animated-splash-screen";
import { Page_styleLoadingBar03 } from "../../pages/Page_styleLoadingBar03";
const styleLoadingBar03StackNavigator = createStackNavigator();
export const ScreenForstyleLoadingBar03 = ({ navigation }) => {
	return (
		<styleLoadingBar03StackNavigator.Navigator>
			<styleLoadingBar03StackNavigator.Screen
				name = "styleLoadingBar03"
				component = {Page_styleLoadingBar03}
				options = {{
					headerShown: false
				}}
			/>
		</styleLoadingBar03StackNavigator.Navigator>
	)
};
