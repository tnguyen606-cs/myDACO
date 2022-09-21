import React, { useState, useRef, useEffect, createRef } from "react";
import { View, Text, Image, ScrollView, SafeAreaView, TextInput, StyleSheet, Animated, Dimensions, Vibration, Alert, ActivityIndicator, KeyboardAvoidingView, TouchableWithoutFeedback, TouchableOpacity, Platform} from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { Svg, Path } from "react-native-svg"
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createStackNavigator } from '@react-navigation/stack';
import AnimatedSplash from "react-native-animated-splash-screen";
import { Page_styleManifestModificationScreen_R_jBcGplYZaC9ejrfu6mJ } from "../../pages/Page_styleManifestModificationScreen_R_jBcGplYZaC9ejrfu6mJ";
const styleManifestModificationScreen_R_jBcGplYZaC9ejrfu6mJStackNavigator = createStackNavigator();
export const ScreenForstyleManifestModificationScreen_R_jBcGplYZaC9ejrfu6mJ = ({ navigation }) => {
	return (
		<styleManifestModificationScreen_R_jBcGplYZaC9ejrfu6mJStackNavigator.Navigator>
			<styleManifestModificationScreen_R_jBcGplYZaC9ejrfu6mJStackNavigator.Screen
				name = "styleManifestModificationScreen_R_jBcGplYZaC9ejrfu6mJ"
				component = {Page_styleManifestModificationScreen_R_jBcGplYZaC9ejrfu6mJ}
				options = {{
					headerShown: false
				}}
			/>
		</styleManifestModificationScreen_R_jBcGplYZaC9ejrfu6mJStackNavigator.Navigator>
	)
};
