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
export const Page_styleSearchingForJ = ({ route, navigation }) => {
	const { signIn, signOut, signUp, authData , resetPassword} = useAuth();
	return (
		<ScrollView style={{width: Dimensions.get("window").width, height: Dimensions.get("window").height, backgroundColor: "rgba(255, 255, 255, 1)"}} horizontal = {false} showsVerticalScrollIndicator={false} showsHorizontalScrollIndicator={false} bounces={false}>
			<View style={{width: Dimensions.get("window").width, height: 141}} >
				<View style = {stylesheet.styleStylename}>
					<View style = {stylesheet.styleSearchOptions}>
						<View style = {stylesheet.styleRectangle18}>
							<Svg
								fill = "rgba(196, 196, 196, 1)"
							>
								<Path d="M0 5C0 2.23858 2.23858 0 5 0L395 0C397.761 0 400 2.23858 400 5L400 136C400 138.761 397.761 141 395 141L5 141C2.23857 141 0 138.761 0 136L0 5Z"/>
							</Svg>
						</View>
						<Text style = {stylesheet.styleSearchingForJInManifest}>
							Searching for “J” in manifest
						</Text>
						<Text style = {stylesheet.styleCaptainJacobBarrett}>
							Captain Jacob Barrett
						</Text>
						<Text style = {stylesheet.styleAleniaC27jSpartan}>
							Alenia C-27J Spartan
						</Text>
						<Text style = {stylesheet.stylePrivateJeremy}>
							Private Jeremy
						</Text>
						<Text style = {stylesheet.styleAircraftInJapan}>
							aircraft in Japan
						</Text>
						<Text style = {stylesheet.styleSergeantJames}>
							Sergeant James
						</Text>
					</View>
				</View>
			</View>
		</ScrollView>
	)
}
const stylesheet = StyleSheet.create({
 	styleRectangle18: {
		position: "absolute",
		left: 0,
		right: -400,
		top: 0,
		bottom: -141,
		width: "auto",
		height: "auto",
	},
	styleSearchingForJInManifest: {
		position: "absolute",
		left: 76,
		top: 14,
		width: 267,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 14,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.20000000000000007,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "center",
		height: "auto",
		lineHeight: 16.4,
	},
	styleCaptainJacobBarrett: {
		position: "absolute",
		left: 111,
		top: 36,
		width: 181,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 12,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.10000000000000009,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 14.1,
	},
	styleAleniaC27jSpartan: {
		position: "absolute",
		left: 115,
		top: 58,
		width: 170,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 12,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.10000000000000009,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 14.1,
	},
	stylePrivateJeremy: {
		position: "absolute",
		left: 142,
		top: 77,
		width: 125,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 12,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.10000000000000009,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 14.1,
	},
	styleAircraftInJapan: {
		position: "absolute",
		left: 134,
		top: 99,
		width: 139,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 12,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.10000000000000009,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 14.1,
	},
	styleSergeantJames: {
		position: "absolute",
		left: 141,
		top: 118,
		width: 129,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 12,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.10000000000000009,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 14.1,
	},
	styleSearchOptions: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 400,
		height: 141,
	},
	styleStylename: {
		position: "relative",
		width: Dimensions.get("window").width,
		height: 141,
		backgroundColor: "rgba(255, 255, 255, 1)",
	},

});