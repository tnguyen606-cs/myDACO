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
export const Page_styleHelpDocumentationScreen = ({ route, navigation }) => {
	const { signIn, signOut, signUp, authData , resetPassword} = useAuth();
	return (
		<ScrollView style={{width: Dimensions.get("window").width, height: Dimensions.get("window").height, backgroundColor: "rgba(255, 255, 255, 1)"}} horizontal = {false} showsVerticalScrollIndicator={false} showsHorizontalScrollIndicator={false} bounces={false}>
			<View style={{width: Dimensions.get("window").width, height: 700}} >
				<View style = {stylesheet.styleStylename}>
					<Text style = {stylesheet.styleHelp}>
						Help

					</Text>
					<Text style = {stylesheet.styleDone}>
						Done
					</Text>
					<View style = {stylesheet.styleRectangle20}>
					</View>
					<Text style = {stylesheet.styleFindAnswersToCommonQuestions}>
						Find answers to common questions
					</Text>
					<Text style = {stylesheet.styleSearchTheDacoAppDocumentation}>
						Search the DACO App Documentation
					</Text>
					<View style = {stylesheet.styleRectangle21}>
					</View>
					<Text style = {stylesheet.styleIfTheDacoAppMisbehavesTellUs}>
						If the DACO App misbehaves, tell us

					</Text>
					<Text style = {stylesheet.styleReportAProblem}>
						Report a Problem
					</Text>
					<View style = {stylesheet.styleRectangle22}>
					</View>
					<View style = {stylesheet.styleRectangle23}>
					</View>
					<View style = {stylesheet.styleRectangle24}>
					</View>
					<Text style = {stylesheet.styleDacoAppHotline}>
						Daco App Hotline
					</Text>
					<Text style = {stylesheet.style15554343232}>
						1-555-434-3232
					</Text>
				</View>
			</View>
		</ScrollView>
	)
}
const stylesheet = StyleSheet.create({
 	styleHelp: {
		position: "absolute",
		left: 158,
		top: 28,
		width: 99,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 24,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.7000000000000002,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 28.1,
	},
	styleDone: {
		position: "absolute",
		left: 336,
		top: 28,
		width: 60,
		color: "rgba(27, 136, 215, 1)",
		fontSize: 24,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.7000000000000002,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 28.1,
	},
	styleRectangle20: {
		position: "absolute",
		left: 0,
		top: 121,
		width: 414,
		height: 88,
		borderWidth: 1,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(196, 196, 196, 1)",
	},
	styleFindAnswersToCommonQuestions: {
		position: "absolute",
		left: 11,
		top: 165,
		width: 366,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 22,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.6000000000000001,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "center",
		height: "auto",
		lineHeight: 25.8,
	},
	styleSearchTheDacoAppDocumentation: {
		position: "absolute",
		left: 11,
		top: 136,
		width: 396,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 22,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.6000000000000001,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 25.8,
	},
	styleRectangle21: {
		position: "absolute",
		left: 0,
		top: 209,
		width: 414,
		height: 88,
		borderWidth: 1,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(196, 196, 196, 1)",
	},
	styleIfTheDacoAppMisbehavesTellUs: {
		position: "absolute",
		left: -10,
		top: 253,
		width: 406,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 22,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.6000000000000001,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "center",
		height: "auto",
		lineHeight: 25.8,
	},
	styleReportAProblem: {
		position: "absolute",
		left: 11,
		top: 220,
		width: 189,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 22,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.6000000000000001,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 25.8,
	},
	styleRectangle22: {
		position: "absolute",
		left: 0,
		top: 297,
		width: 414,
		height: 88,
		borderWidth: 1,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(196, 196, 196, 1)",
	},
	styleRectangle23: {
		position: "absolute",
		left: 0,
		top: 385,
		width: 414,
		height: 88,
		borderWidth: 1,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(196, 196, 196, 1)",
	},
	styleRectangle24: {
		position: "absolute",
		left: 0,
		top: 473,
		width: 414,
		height: 88,
		borderWidth: 1,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(196, 196, 196, 1)",
	},
	styleDacoAppHotline: {
		position: "absolute",
		left: 11,
		top: 310,
		width: 185,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 22,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.6000000000000001,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 25.8,
	},
	style15554343232: {
		position: "absolute",
		left: 11,
		top: 341,
		width: 161,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 22,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.6000000000000001,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "center",
		height: "auto",
		lineHeight: 25.8,
	},
	styleStylename: {
		position: "relative",
		width: Dimensions.get("window").width,
		height: 700,
		backgroundColor: "rgba(255, 255, 255, 1)",
	},

});