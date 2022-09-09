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
export const Page_styleHistory2 = ({ route, navigation }) => {
	const { signIn, signOut, signUp, authData , resetPassword} = useAuth();
	return (
		<ScrollView style={{width: Dimensions.get("window").width, height: Dimensions.get("window").height, backgroundColor: "rgba(255, 255, 255, 1)"}} horizontal = {false} showsVerticalScrollIndicator={false} showsHorizontalScrollIndicator={false} bounces={false}>
			<View style={{width: Dimensions.get("window").width, height: 300}} >
				<View style = {stylesheet.styleStylename}>
					<View style = {stylesheet.styleRectangle25}>
					</View>
					<Text style = {stylesheet.styleRevert}>
						Revert
					</Text>
					<Text style = {stylesheet.styleKeep}>
						Keep
					</Text>
					<Text style = {stylesheet.styleLoad1WasRemovedFromPlane1}>
						Load 1 was removed from Plane 1
					</Text>
					<View style = {stylesheet.styleRectangle26}>
					</View>
					<Text style = {stylesheet.styleKeepCopy1}>
						Keep
					</Text>
					<Text style = {stylesheet.styleRevertCopy1}>
						Revert
					</Text>
					<Text style = {stylesheet.styleJohnDoeWasTransferredToPlane2}>
						John Doe was transferred to Plane 2
					</Text>
				</View>
			</View>
		</ScrollView>
	)
}
const stylesheet = StyleSheet.create({
 	styleRectangle25: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 400,
		height: 150,
		borderWidth: 1,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(196, 196, 196, 1)",
	},
	styleRevert: {
		position: "absolute",
		left: 288,
		top: 115,
		width: 63,
		color: "rgba(255, 4, 4, 1)",
		fontSize: 20,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.5,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "center",
		height: "auto",
		lineHeight: 23.4,
	},
	styleKeep: {
		position: "absolute",
		left: 51,
		top: 115,
		width: 47,
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
	styleLoad1WasRemovedFromPlane1: {
		position: "absolute",
		left: 42,
		top: 63,
		width: 317,
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
	styleRectangle26: {
		position: "absolute",
		left: 0,
		top: 150,
		width: 400,
		height: 150,
		borderWidth: 1,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(196, 196, 196, 1)",
	},
	styleKeepCopy1: {
		position: "absolute",
		left: 51,
		top: 258,
		width: 47,
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
	styleRevertCopy1: {
		position: "absolute",
		left: 288,
		top: 258,
		width: 63,
		color: "rgba(255, 4, 4, 1)",
		fontSize: 20,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.5,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "center",
		height: "auto",
		lineHeight: 23.4,
	},
	styleJohnDoeWasTransferredToPlane2: {
		position: "absolute",
		left: 30,
		top: 202,
		width: 341,
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
		height: 300,
		backgroundColor: "rgba(255, 255, 255, 1)",
	},

});