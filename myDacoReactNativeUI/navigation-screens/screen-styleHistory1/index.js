import React, { useState, useRef, useEffect, createRef } from "react";
import { View, Text, Image, ScrollView, SafeAreaView, TextInput, StyleSheet, Animated, Dimensions, Vibration, Alert, ActivityIndicator, KeyboardAvoidingView, TouchableWithoutFeedback, TouchableOpacity, Platform} from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { Svg, Path } from "react-native-svg"
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createStackNavigator } from '@react-navigation/stack';
import AnimatedSplash from "react-native-animated-splash-screen";
import { Page_styleHistory1 } from "../../pages/Page_styleHistory1";
const styleHistory1StackNavigator = createStackNavigator();
export const ScreenForstyleHistory1 = ({ navigation }) => {
	return (
		<styleHistory1StackNavigator.Navigator>
			<styleHistory1StackNavigator.Screen
				name = "styleHistory1"
				component = {Page_styleHistory1}
				options = {{
					headerShown: false
				}}
			/>
		</styleHistory1StackNavigator.Navigator>
	)
};
