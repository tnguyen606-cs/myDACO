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
export const Page_styleForgotPasswordScreen = ({ route, navigation }) => {
	const { signIn, signOut, signUp, authData , resetPassword} = useAuth();
	return (
		<ScrollView style={{width: Dimensions.get("window").width, height: Dimensions.get("window").height, backgroundColor: "rgba(255, 255, 255, 1)"}} horizontal = {false} showsVerticalScrollIndicator={false} showsHorizontalScrollIndicator={false} bounces={false}>
			<View style={{width: Dimensions.get("window").width, height: 800}} >
				<View style = {stylesheet.styleStylename}>
					<View style = {stylesheet.styleTextfieldGroup}>
						<Text style = {stylesheet.styleFirstName_}>
							First Name:
						</Text>
						<Text style = {stylesheet.styleLastName_}>
							Last Name:
						</Text>
						<Text style = {stylesheet.styleEmployeeId_}>
							Employee ID:
						</Text>
						<Text style = {stylesheet.styleContactInfo}>
							Please contact the Department of Registration to verify your ID. 
						</Text>
						<View style = {stylesheet.styleUsernamebox}>
						</View>
						<View style = {stylesheet.stylePasswordbox}>
						</View>
						<View style = {stylesheet.styleIdBox}>
						</View>
					</View>
					<View style = {stylesheet.styleDacoApp}>
						<Text style = {stylesheet.styleDacoAppCopy1}>
							DACO APP
						</Text>
					</View>
					<View style = {stylesheet.styleGoBackButton}>
						<Image style = {stylesheet.styleIconsBack1} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/8YVj0U5kSvFbckgLuK0zPjpK.png"}}/>
						<Text style = {stylesheet.styleGoBack}>
							Go Back 
						</Text>
					</View>
					<View style = {stylesheet.styleLoginButton}>
						<View style = {stylesheet.styleLoginbox}>
						</View>
						<Text style = {stylesheet.styleRegister}>
							Register
						</Text>
					</View>
				</View>
			</View>
		</ScrollView>
	)
}
const stylesheet = StyleSheet.create({
 	styleFirstName_: {
		position: "absolute",
		left: 17,
		top: 0,
		width: 97,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 18,
		fontFamily: "Arial_400Regular",
		letterSpacing: -0.5,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "left",
		height: "auto",
		lineHeight: 21.1,
	},
	styleLastName_: {
		position: "absolute",
		left: 17,
		top: 88,
		width: 97,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 18,
		fontFamily: "Arial_400Regular",
		letterSpacing: -0.5,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "left",
		height: "auto",
		lineHeight: 21.1,
	},
	styleEmployeeId_: {
		position: "absolute",
		left: 17,
		top: 176,
		width: 97,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 18,
		fontFamily: "Arial_400Regular",
		letterSpacing: -0.5,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "left",
		height: "auto",
		lineHeight: 21.1,
	},
	styleContactInfo: {
		position: "absolute",
		left: 11,
		top: 290,
		width: 255,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 15,
		fontFamily: "Arial_400Regular",
		letterSpacing: -0.5,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 17.6,
	},
	styleUsernamebox: {
		position: "absolute",
		left: 0,
		top: 26,
		width: 285,
		height: 50,
		borderRadius: 40,
		borderWidth: 1,
		borderColor: "rgba(56, 137, 196, 1)",
		backgroundColor: "rgba(248, 248, 248, 1)",
	},
	stylePasswordbox: {
		position: "absolute",
		left: 0,
		top: 114,
		width: 285,
		height: 50,
		borderRadius: 40,
		borderWidth: 1,
		borderColor: "rgba(56, 137, 196, 1)",
		backgroundColor: "rgba(248, 248, 248, 1)",
	},
	styleIdBox: {
		position: "absolute",
		left: 0,
		top: 202,
		width: 285,
		height: 50,
		borderRadius: 40,
		borderWidth: 1,
		borderColor: "rgba(56, 137, 196, 1)",
		backgroundColor: "rgba(248, 248, 248, 1)",
	},
	styleTextfieldGroup: {
		position: "absolute",
		left: 31,
		top: 256,
		width: 285,
		height: 326,
	},
	styleDacoAppCopy1: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 249,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 48,
		fontFamily: "Arial_400Regular",
		letterSpacing: 1.9000000000000004,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 56.3,
	},
	styleDacoApp: {
		position: "absolute",
		left: 57,
		top: 65,
		width: 247,
		height: 59,
	},
	styleIconsBack1: {
		position: "absolute",
		left: 0,
		top: 0,
		borderRadius: null,
		width: 40,
		height: 40,
	},
	styleGoBack: {
		position: "absolute",
		left: 34,
		top: 5,
		width: 94,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 25,
		fontFamily: "Arial_400Regular",
		letterSpacing: -0.5,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 29.3,
	},
	styleGoBackButton: {
		position: "absolute",
		left: 3,
		top: 740,
		width: 126,
		height: 40,
	},
	styleLoginbox: {
		position: "absolute",
		left: 9,
		top: 0,
		width: 118,
		height: 40,
		borderRadius: 40,
		borderWidth: 1,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(27, 136, 215, 1)",
	},
	styleRegister: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 138,
		color: "rgba(255, 255, 255, 1)",
		fontSize: 22,
		fontFamily: "Arial_400Regular",
		letterSpacing: -0.5,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 25.8,
	},
	styleLoginButton: {
		position: "absolute",
		left: 112,
		top: 638,
		width: 136,
		height: 40,
	},
	styleStylename: {
		position: "relative",
		width: Dimensions.get("window").width,
		height: 800,
		backgroundColor: "rgba(255, 255, 255, 1)",
	},

});