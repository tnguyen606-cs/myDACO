import React, { useState, useRef, useEffect, createRef } from "react";
import { View, Text, Image, ScrollView, SafeAreaView, TextInput, StyleSheet, Animated, Dimensions, Vibration, Alert, ActivityIndicator, KeyboardAvoidingView, TouchableWithoutFeedback, TouchableOpacity, Platform} from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { Svg, Path } from "react-native-svg"
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createStackNavigator } from '@react-navigation/stack';
import AnimatedSplash from "react-native-animated-splash-screen";
import { Page_styleMainMenuScreenAfterBumpA } from "../../pages/Page_styleMainMenuScreenAfterBumpA";
const styleMainMenuScreenAfterBumpAStackNavigator = createStackNavigator();
export const ScreenForstyleMainMenuScreenAfterBumpA = ({ navigation }) => {
	return (
		<styleMainMenuScreenAfterBumpAStackNavigator.Navigator>
			<styleMainMenuScreenAfterBumpAStackNavigator.Screen
				name = "styleMainMenuScreenAfterBumpA"
				component = {Page_styleMainMenuScreenAfterBumpA}
				options = {{
					headerShown: false
				}}
			/>
		</styleMainMenuScreenAfterBumpAStackNavigator.Navigator>
	)
};
