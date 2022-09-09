import React, { useState, useRef, useEffect, createRef } from "react";
import { View, Text, Image, ScrollView, Switch, SafeAreaView, TextInput, TouchableWithoutFeedback, TouchableOpacity, StyleSheet, Animated, Dimensions, Vibration, Alert, KeyboardAvoidingView, Platform} from "react-native";
import { Svg, Path } from "react-native-svg";
import CheckBox from "react-native-check-box";
import { WebView } from "react-native-webview";
import { HtmlText } from "@e-mine/react-native-html-text";
import BottomSheet from "@gorhom/bottom-sheet";
import { useAuth } from "../../entities/auth";
import Icon from "react-native-vector-icons/Entypo";
import { getTable } from "../../shared/api/data";
export const Page_styleRemove = ({ route, navigation }) => {
	const { signIn, signOut, signUp, authData , resetPassword} = useAuth();
	return (
		<ScrollView style={{width: Dimensions.get("window").width, height: Dimensions.get("window").height, backgroundColor: "rgba(255, 255, 255, 1)"}} horizontal = {false} showsVerticalScrollIndicator={false} showsHorizontalScrollIndicator={false} bounces={false}>
			<View style={{width: Dimensions.get("window").width, height: 143}} >
				<View style = {stylesheet.styleStylename}>
					<Text style = {stylesheet.styleTransfer}>
						Transfer 
					</Text>
					<Text style = {stylesheet.styleRemove}>
						Remove 
					</Text>
					<Text style = {stylesheet.styleModifyAssignmentForLoad1_}>
						Modify assignment for Load 1:
					</Text>
					<Text style = {stylesheet.styleCancel}>
						Cancel
					</Text>
				</View>
			</View>
		</ScrollView>
	)
}
const stylesheet = StyleSheet.create({
 	styleTransfer: {
		position: "absolute",
		left: 199,
		top: 102,
		width: 80,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 20,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.5,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "left",
		height: "auto",
		lineHeight: 23.4,
	},
	styleRemove: {
		position: "absolute",
		left: 99,
		top: 102,
		width: 76,
		color: "rgba(255, 0, 0, 1)",
		fontSize: 20,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.5,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "left",
		height: "auto",
		lineHeight: 23.4,
	},
	styleModifyAssignmentForLoad1_: {
		position: "absolute",
		left: 49,
		top: 40,
		width: 284,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 20,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.5,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "left",
		height: "auto",
		lineHeight: 23.4,
	},
	styleCancel: {
		position: "absolute",
		left: 305,
		top: 102,
		width: 64,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 20,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.5,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "center",
		height: "auto",
		lineHeight: 23.4,
	},
	styleStylename: {
		position: "relative",
		width: Dimensions.get("window").width,
		height: 143,
		backgroundColor: "rgba(255, 255, 255, 1)",
	},

});