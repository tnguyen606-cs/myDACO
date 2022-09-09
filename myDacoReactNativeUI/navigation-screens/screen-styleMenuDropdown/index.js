import React, { useState, useRef, useEffect, createRef } from "react";
import { View, Text, Image, ScrollView, SafeAreaView, TextInput, StyleSheet, Animated, Dimensions, Vibration, Alert, ActivityIndicator, KeyboardAvoidingView, TouchableWithoutFeedback, TouchableOpacity, Platform} from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { Svg, Path } from "react-native-svg"
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createStackNavigator } from '@react-navigation/stack';
import AnimatedSplash from "react-native-animated-splash-screen";
import { Page_styleMenuDropdown } from "../../pages/Page_styleMenuDropdown";
const styleMenuDropdownStackNavigator = createStackNavigator();
export const ScreenForstyleMenuDropdown = ({ navigation }) => {
	return (
		<styleMenuDropdownStackNavigator.Navigator>
			<styleMenuDropdownStackNavigator.Screen
				name = "styleMenuDropdown"
				component = {Page_styleMenuDropdown}
				options = {{
					headerShown: false
				}}
			/>
		</styleMenuDropdownStackNavigator.Navigator>
	)
};
