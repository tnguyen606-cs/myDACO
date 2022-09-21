import React, { useState, useRef, useEffect, createRef } from "react";
import { View, Text, Image, ScrollView, SafeAreaView, TextInput, StyleSheet, Animated, Dimensions, Vibration, Alert, ActivityIndicator, KeyboardAvoidingView, TouchableWithoutFeedback, TouchableOpacity, Platform} from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { Svg, Path } from "react-native-svg"
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createStackNavigator } from '@react-navigation/stack';
import AnimatedSplash from "react-native-animated-splash-screen";
import { Page_styleManifestModificationScreen_ } from "../../pages/Page_styleManifestModificationScreen_";
const styleManifestModificationScreen_StackNavigator = createStackNavigator();
export const ScreenForstyleManifestModificationScreen_ = ({ navigation }) => {
	return (
		<styleManifestModificationScreen_StackNavigator.Navigator>
			<styleManifestModificationScreen_StackNavigator.Screen
				name = "styleManifestModificationScreen_"
				component = {Page_styleManifestModificationScreen_}
				options = {{
					headerShown: false
				}}
			/>
		</styleManifestModificationScreen_StackNavigator.Navigator>
	)
};
