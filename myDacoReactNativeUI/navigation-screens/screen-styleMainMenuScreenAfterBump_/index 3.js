import React, { useState, useRef, useEffect, createRef } from "react";
import { View, Text, Image, ScrollView, SafeAreaView, TextInput, StyleSheet, Animated, Dimensions, Vibration, Alert, ActivityIndicator, KeyboardAvoidingView, TouchableWithoutFeedback, TouchableOpacity, Platform} from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { Svg, Path } from "react-native-svg"
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createStackNavigator } from '@react-navigation/stack';
import AnimatedSplash from "react-native-animated-splash-screen";
import { Page_styleMainMenuScreenAfterBump_ } from "../../pages/Page_styleMainMenuScreenAfterBump_";
const styleMainMenuScreenAfterBump_StackNavigator = createStackNavigator();
export const ScreenForstyleMainMenuScreenAfterBump_ = ({ navigation }) => {
	return (
		<styleMainMenuScreenAfterBump_StackNavigator.Navigator>
			<styleMainMenuScreenAfterBump_StackNavigator.Screen
				name = "styleMainMenuScreenAfterBump_"
				component = {Page_styleMainMenuScreenAfterBump_}
				options = {{
					headerShown: false
				}}
			/>
		</styleMainMenuScreenAfterBump_StackNavigator.Navigator>
	)
};
