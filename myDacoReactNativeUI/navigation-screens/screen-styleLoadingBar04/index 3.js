import React, { useState, useRef, useEffect, createRef } from "react";
import { View, Text, Image, ScrollView, SafeAreaView, TextInput, StyleSheet, Animated, Dimensions, Vibration, Alert, ActivityIndicator, KeyboardAvoidingView, TouchableWithoutFeedback, TouchableOpacity, Platform} from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { Svg, Path } from "react-native-svg"
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createStackNavigator } from '@react-navigation/stack';
import AnimatedSplash from "react-native-animated-splash-screen";
import { Page_styleLoadingBar04 } from "../../pages/Page_styleLoadingBar04";
const styleLoadingBar04StackNavigator = createStackNavigator();
export const ScreenForstyleLoadingBar04 = ({ navigation }) => {
	return (
		<styleLoadingBar04StackNavigator.Navigator>
			<styleLoadingBar04StackNavigator.Screen
				name = "styleLoadingBar04"
				component = {Page_styleLoadingBar04}
				options = {{
					headerShown: false
				}}
			/>
		</styleLoadingBar04StackNavigator.Navigator>
	)
};
