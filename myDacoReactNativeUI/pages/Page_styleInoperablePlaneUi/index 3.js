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
export const Page_styleInoperablePlaneUi = ({ route, navigation }) => {
	const { signIn, signOut, signUp, authData , resetPassword} = useAuth();
	return (
		<ScrollView style={{width: Dimensions.get("window").width, height: Dimensions.get("window").height, backgroundColor: "rgba(255, 255, 255, 1)"}} horizontal = {false} showsVerticalScrollIndicator={false} showsHorizontalScrollIndicator={false} bounces={false}>
			<View style={{width: Dimensions.get("window").width, height: 204}} >
				<View style = {stylesheet.styleStylename}>
					<Text style = {stylesheet.styleIsThisPlaneNowInoperable_}>
						Is this plane now inoperable?
					</Text>
					<View style = {stylesheet.styleRectangle13}>
					</View>
					<View style = {stylesheet.styleLine18}>
						<Svg
							stroke = "rgba(0, 0, 0, 1)"
						>
							<Path d=""/>
						</Svg>
					</View>
					<Text style = {stylesheet.styleYes}>
						Yes

					</Text>
					<Text style = {stylesheet.styleNo}>
						No
					</Text>
				</View>
			</View>
		</ScrollView>
	)
}
const stylesheet = StyleSheet.create({
 	styleIsThisPlaneNowInoperable_: {
		position: "absolute",
		left: 17,
		top: 34,
		width: 277,
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
	styleRectangle13: {
		position: "absolute",
		left: 83,
		top: 78,
		width: 143,
		height: 72,
		borderWidth: 1,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(248, 248, 248, 1)",
	},
	styleLine18: {
		position: "absolute",
		left: 83.9921875,
		right: -56.0078125,
		top: 112.31298828125,
		bottom: 108,
		width: "auto",
		height: "auto",
	},
	styleYes: {
		position: "absolute",
		left: 139,
		top: 84,
		width: 33,
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
	styleNo: {
		position: "absolute",
		left: 142,
		top: 118,
		width: 27,
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
	styleStylename: {
		position: "relative",
		width: Dimensions.get("window").width,
		height: 204,
		backgroundColor: "rgba(255, 255, 255, 1)",
	},

});