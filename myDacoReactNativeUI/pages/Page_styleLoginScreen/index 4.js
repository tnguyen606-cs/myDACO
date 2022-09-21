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
export const Page_styleLoginScreen = ({ route, navigation }) => {
	const { signIn, signOut, signUp, authData , resetPassword} = useAuth();
	return (
		<ScrollView style={{width: Dimensions.get("window").width, height: Dimensions.get("window").height, backgroundColor: "rgba(255, 255, 255, 1)"}} horizontal = {false} showsVerticalScrollIndicator={false} showsHorizontalScrollIndicator={false} bounces={false}>
			<View style={{width: Dimensions.get("window").width, height: 786}} >
				<View style = {stylesheet.styleStylename}>
					<View style = {stylesheet.styleLoginButton}>
						<View style = {stylesheet.styleLoginbox}>
						</View>
						<Text style = {stylesheet.styleLogin}>
							Login
						</Text>
					</View>
					<View style = {stylesheet.styleTextfieldGroup}>
						<Text style = {stylesheet.styleForgotPassword}>
							Forgot Password?
						</Text>
						<Text style = {stylesheet.styleUsername}>
							Username
						</Text>
						<View style = {stylesheet.styleUsernamebox}>
						</View>
						<Text style = {stylesheet.stylePassword}>
							Password 
						</Text>
						<View style = {stylesheet.stylePasswordbox}>
						</View>
						<Image style = {stylesheet.stylePasswordIcon} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/mkeQF4hqPruuMIF8dUBZRHvJ.png"}}/>
						<Image style = {stylesheet.styleUsernameIcon} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/Y0D7ep2wGaSYk6TBShB3lCco.png"}}/>
					</View>
					<View style = {stylesheet.styleDacoApp}>
						<Text style = {stylesheet.styleDacoAppCopy1}>
							DACO APP
						</Text>
						<Image style = {stylesheet.styleAircaftIcon} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/IJcdCZGCCv61A9SfVsypCDmw.png"}}/>
					</View>
					<View style = {stylesheet.styleTopGroup}>
						<Image style = {stylesheet.styleBatteryIcon} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/k2730s5swJSei4dBGAl10NJg.png"}}/>
						<Image style = {stylesheet.styleSignalIcon1} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/xfr31YOSCtxIClAaEVp3cAlg.png"}}/>
						<Text style = {stylesheet.style1100}>
							11:00
						</Text>
					</View>
					<View style = {stylesheet.styleNewUsersGroup}>
						<Text style = {stylesheet.styleSignUp}>
							New users? 
						</Text>
						<View style = {stylesheet.styleClickHereButton}>
							<View style = {stylesheet.styleRectangle10}>
							</View>
							<Text style = {stylesheet.styleClickHere}>
								Click here
							</Text>
						</View>
					</View>
				</View>
			</View>
		</ScrollView>
	)
}
const stylesheet = StyleSheet.create({
 	styleLoginbox: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 129,
		height: 45,
		borderRadius: 40,
		borderWidth: 1,
		borderColor: "rgba(0, 0, 0, 1)",
		backgroundColor: "rgba(27, 136, 215, 1)",
	},
	styleLogin: {
		position: "absolute",
		left: 2,
		top: 0,
		width: 128,
		color: "rgba(255, 255, 255, 1)",
		fontSize: 28,
		fontFamily: "Arial_400Regular",
		letterSpacing: -0.5,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 32.8,
	},
	styleLoginButton: {
		position: "absolute",
		left: 143,
		top: 621,
		width: 129,
		height: 45,
	},
	styleForgotPassword: {
		position: "absolute",
		left: 198,
		top: 172,
		width: 154,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 18,
		fontFamily: "Arial_400Regular",
		letterSpacing: -0.5,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "center",
		height: "auto",
		lineHeight: 21.1,
	},
	styleUsername: {
		position: "absolute",
		left: 59,
		top: 0,
		width: 119,
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
	styleUsernamebox: {
		position: "absolute",
		left: 0,
		top: 26,
		width: 350,
		height: 50,
		borderRadius: 40,
		borderWidth: 1,
		borderColor: "rgba(56, 137, 196, 1)",
		backgroundColor: "rgba(248, 248, 248, 1)",
	},
	stylePassword: {
		position: "absolute",
		left: 59,
		top: 88,
		width: 141,
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
	stylePasswordbox: {
		position: "absolute",
		left: 0,
		top: 114,
		width: 350,
		height: 50,
		borderRadius: 40,
		borderWidth: 1,
		borderColor: "rgba(56, 137, 196, 1)",
		backgroundColor: "rgba(248, 248, 248, 1)",
	},
	stylePasswordIcon: {
		position: "absolute",
		left: 18,
		top: 88,
		borderRadius: null,
		width: 23,
		height: 20,
	},
	styleUsernameIcon: {
		position: "absolute",
		left: 20,
		top: 0,
		borderRadius: null,
		width: 20,
		height: 20,
	},
	styleTextfieldGroup: {
		position: "absolute",
		left: 33,
		top: 400,
		width: 350,
		height: 196,
	},
	styleDacoAppCopy1: {
		position: "absolute",
		left: 0,
		top: 190,
		width: 325,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 64,
		fontFamily: "Arial_400Regular",
		letterSpacing: 2.7,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "center",
		height: "auto",
		lineHeight: 75,
	},
	styleAircaftIcon: {
		position: "absolute",
		left: 95,
		top: 0,
		borderRadius: null,
		width: 157,
		height: 190,
	},
	styleDacoApp: {
		position: "absolute",
		left: 48,
		top: 64,
		width: 323,
		height: 267,
	},
	styleBatteryIcon: {
		position: "absolute",
		left: 360,
		top: 2,
		borderRadius: null,
		width: 29,
		height: 18,
	},
	styleSignalIcon1: {
		position: "absolute",
		left: 327,
		top: 2,
		borderRadius: null,
		width: 28,
		height: 18,
	},
	style1100: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 53,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 18,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.4,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "left",
		height: "auto",
		lineHeight: 21.1,
	},
	styleTopGroup: {
		position: "absolute",
		left: 11,
		top: 8,
		width: 389,
		height: 20,
	},
	styleSignUp: {
		position: "absolute",
		left: 0,
		top: 3,
		width: 112,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 20,
		fontFamily: "Arial_400Regular",
		letterSpacing: -0.5,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "center",
		height: "auto",
		lineHeight: 23.4,
	},
	styleRectangle10: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 85,
		height: 26,
		backgroundColor: "rgba(196, 196, 196, 1)",
	},
	styleClickHere: {
		position: "absolute",
		left: 3,
		top: 3,
		width: 84,
		color: "rgba(26, 135, 214, 1)",
		fontSize: 20,
		fontFamily: "Arial_400Regular",
		letterSpacing: -0.5,
		fontStyle: "normal",
		fontWeight: "500",
		textAlign: "center",
		height: "auto",
		lineHeight: 23.4,
	},
	styleClickHereButton: {
		position: "absolute",
		left: 98,
		top: 0,
		width: 85,
		height: 26,
	},
	styleNewUsersGroup: {
		position: "absolute",
		left: 117,
		top: 691,
		width: 183,
		height: 29,
	},
	styleStylename: {
		position: "relative",
		width: Dimensions.get("window").width,
		height: 786,
		backgroundColor: "rgba(255, 255, 255, 1)",
	},

});