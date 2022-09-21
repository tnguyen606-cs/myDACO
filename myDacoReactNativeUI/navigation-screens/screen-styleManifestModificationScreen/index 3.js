import React, { useState, useRef, useEffect, createRef } from "react";
import { View, Text, Image, ScrollView, SafeAreaView, TextInput, StyleSheet, Animated, Dimensions, Vibration, Alert, ActivityIndicator, KeyboardAvoidingView, TouchableWithoutFeedback, TouchableOpacity, Platform} from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { Svg, Path } from "react-native-svg"
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createStackNavigator } from '@react-navigation/stack';
import AnimatedSplash from "react-native-animated-splash-screen";
import { Page_styleManifestModificationScreen } from "../../pages/Page_styleManifestModificationScreen";
const styleManifestModificationScreenStackNavigator = createStackNavigator();
export const ScreenForstyleManifestModificationScreen = ({ navigation }) => {
	return (
		<styleManifestModificationScreenStackNavigator.Navigator>
			<styleManifestModificationScreenStackNavigator.Screen
				name = "styleManifestModificationScreen"
				component = {Page_styleManifestModificationScreen}
				options = {{
					headerShown: false
				}}
			/>
		</styleManifestModificationScreenStackNavigator.Navigator>
	)
};
