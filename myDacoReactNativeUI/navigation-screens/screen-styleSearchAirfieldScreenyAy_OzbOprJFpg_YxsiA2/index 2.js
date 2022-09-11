import React, { useState, useRef, useEffect, createRef } from "react";
import { View, Text, Image, ScrollView, SafeAreaView, TextInput, StyleSheet, Animated, Dimensions, Vibration, Alert, ActivityIndicator, KeyboardAvoidingView, TouchableWithoutFeedback, TouchableOpacity, Platform} from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { Svg, Path } from "react-native-svg"
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createStackNavigator } from '@react-navigation/stack';
import AnimatedSplash from "react-native-animated-splash-screen";
import { Page_styleSearchAirfieldScreenyAy_OzbOprJFpg_YxsiA2 } from "../../pages/Page_styleSearchAirfieldScreenyAy_OzbOprJFpg_YxsiA2";
const styleSearchAirfieldScreenyAy_OzbOprJFpg_YxsiA2StackNavigator = createStackNavigator();
export const ScreenForstyleSearchAirfieldScreenyAy_OzbOprJFpg_YxsiA2 = ({ navigation }) => {
	return (
		<styleSearchAirfieldScreenyAy_OzbOprJFpg_YxsiA2StackNavigator.Navigator>
			<styleSearchAirfieldScreenyAy_OzbOprJFpg_YxsiA2StackNavigator.Screen
				name = "styleSearchAirfieldScreenyAy_OzbOprJFpg_YxsiA2"
				component = {Page_styleSearchAirfieldScreenyAy_OzbOprJFpg_YxsiA2}
				options = {{
					headerShown: false
				}}
			/>
		</styleSearchAirfieldScreenyAy_OzbOprJFpg_YxsiA2StackNavigator.Navigator>
	)
};
