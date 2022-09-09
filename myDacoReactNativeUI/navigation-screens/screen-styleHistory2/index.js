import React, { useState, useRef, useEffect, createRef } from "react";
import { View, Text, Image, ScrollView, SafeAreaView, TextInput, StyleSheet, Animated, Dimensions, Vibration, Alert, ActivityIndicator, KeyboardAvoidingView, TouchableWithoutFeedback, TouchableOpacity, Platform} from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { Svg, Path } from "react-native-svg"
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createStackNavigator } from '@react-navigation/stack';
import AnimatedSplash from "react-native-animated-splash-screen";
import { Page_styleHistory2 } from "../../pages/Page_styleHistory2";
const styleHistory2StackNavigator = createStackNavigator();
export const ScreenForstyleHistory2 = ({ navigation }) => {
	return (
		<styleHistory2StackNavigator.Navigator>
			<styleHistory2StackNavigator.Screen
				name = "styleHistory2"
				component = {Page_styleHistory2}
				options = {{
					headerShown: false
				}}
			/>
		</styleHistory2StackNavigator.Navigator>
	)
};
