import React, { useState, useRef, useEffect, createRef } from "react";
import { View, Text, Image, ScrollView, SafeAreaView, TextInput, StyleSheet, Animated, Dimensions, Vibration, Alert, ActivityIndicator, KeyboardAvoidingView, TouchableWithoutFeedback, TouchableOpacity, Platform} from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { Svg, Path } from "react-native-svg"
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createStackNavigator } from '@react-navigation/stack';
import AnimatedSplash from "react-native-animated-splash-screen";
import { Page_styleMainMenuScreenBeforeBump_ } from "../../pages/Page_styleMainMenuScreenBeforeBump_";
const styleMainMenuScreenBeforeBump_StackNavigator = createStackNavigator();
export const ScreenForstyleMainMenuScreenBeforeBump_ = ({ navigation }) => {
	return (
		<styleMainMenuScreenBeforeBump_StackNavigator.Navigator>
			<styleMainMenuScreenBeforeBump_StackNavigator.Screen
				name = "styleMainMenuScreenBeforeBump_"
				component = {Page_styleMainMenuScreenBeforeBump_}
				options = {{
					headerShown: false
				}}
			/>
		</styleMainMenuScreenBeforeBump_StackNavigator.Navigator>
	)
};
