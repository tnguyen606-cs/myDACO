import React, { useState, useRef, useEffect, createRef } from "react";
import { View, Text, Image, ScrollView, SafeAreaView, TextInput, StyleSheet, Animated, Dimensions, Vibration, Alert, ActivityIndicator, KeyboardAvoidingView, TouchableWithoutFeedback, TouchableOpacity, Platform} from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { Svg, Path } from "react-native-svg"
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createStackNavigator } from '@react-navigation/stack';
import AnimatedSplash from "react-native-animated-splash-screen";
import { Page_styleLoadingBar02 } from "../../pages/Page_styleLoadingBar02";
const styleLoadingBar02StackNavigator = createStackNavigator();
export const ScreenForstyleLoadingBar02 = ({ navigation }) => {
	return (
		<styleLoadingBar02StackNavigator.Navigator>
			<styleLoadingBar02StackNavigator.Screen
				name = "styleLoadingBar02"
				component = {Page_styleLoadingBar02}
				options = {{
					headerShown: false
				}}
			/>
		</styleLoadingBar02StackNavigator.Navigator>
	)
};
