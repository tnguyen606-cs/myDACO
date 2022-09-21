import React, { useState, useRef, useEffect, createRef } from "react";
import { View, Text, Image, ScrollView, Switch, SafeAreaView, TextInput, TouchableWithoutFeedback, TouchableOpacity, StyleSheet, Animated, Dimensions, Vibration, Alert, KeyboardAvoidingView, Platform} from "react-native";
import { Svg, Path } from "react-native-svg";
import CheckBox from "react-native-check-box";
import { WebView } from "react-native-webview";
import BottomSheet from "@gorhom/bottom-sheet";
import { HtmlText } from "@e-mine/react-native-html-text";
import Icon from "react-native-vector-icons/Entypo";
import { getTable } from "../../shared/api/data";
export const SplashPage = ({ route, navigation }) => {
	return (
			<View style={{width: Dimensions.get("window").width, height: 812}} >
				<View style = {stylesheet.styleStylename}>
				</View>
			</View>
	)
}
const stylesheet = StyleSheet.create({
 	styleStylename: {
		position: "relative",
		width: Dimensions.get("window").width,
		height: 812,
		backgroundColor: "rgba(255, 255, 255, 1)",
	},

});