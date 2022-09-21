import React, { useState, useRef, useEffect, createRef } from "react";
import { View, Text, Image, ScrollView, SafeAreaView, TextInput, StyleSheet, Animated, Dimensions, Vibration, Alert, ActivityIndicator, KeyboardAvoidingView, TouchableWithoutFeedback, TouchableOpacity, Platform} from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { Svg, Path } from "react-native-svg"
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createStackNavigator } from '@react-navigation/stack';
import AnimatedSplash from "react-native-animated-splash-screen";
import { Page_styleRemoveLoadPersonnelOverlay } from "../../pages/Page_styleRemoveLoadPersonnelOverlay";
const styleRemoveLoadPersonnelOverlayStackNavigator = createStackNavigator();
export const ScreenForstyleRemoveLoadPersonnelOverlay = ({ navigation }) => {
	return (
		<styleRemoveLoadPersonnelOverlayStackNavigator.Navigator>
			<styleRemoveLoadPersonnelOverlayStackNavigator.Screen
				name = "styleRemoveLoadPersonnelOverlay"
				component = {Page_styleRemoveLoadPersonnelOverlay}
				options = {{
					headerShown: false
				}}
			/>
		</styleRemoveLoadPersonnelOverlayStackNavigator.Navigator>
	)
};
