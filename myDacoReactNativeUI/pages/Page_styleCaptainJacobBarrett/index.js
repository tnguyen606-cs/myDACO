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
export const Page_styleCaptainJacobBarrett = ({ route, navigation }) => {
	const { signIn, signOut, signUp, authData , resetPassword} = useAuth();
	return (
		<ScrollView style={{width: Dimensions.get("window").width, height: Dimensions.get("window").height, backgroundColor: "rgba(255, 255, 255, 1)"}} horizontal = {false} showsVerticalScrollIndicator={false} showsHorizontalScrollIndicator={false} bounces={false}>
			<View style={{width: Dimensions.get("window").width, height: 252}} >
				<View style = {stylesheet.styleStylename}>
					<Text style = {stylesheet.styleCaptainJacobBarrettPlane2DepartureDateTimeTomorrow100SexMaleUssocomUsasoc75rr375}>
						Captain Jacob Barrett

Plane 2
Departure Date/Time: 
     Tomorrow @ 1:00
Sex: Male
USSOCOM USASOC 75RR 3/75
					</Text>
					<View style = {stylesheet.styleGoBackButton}>
						<Image style = {stylesheet.styleIconsBack1} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/zbAp4IhR1tDf1QbTXEhYTs5W.png"}}/>
						<Text style = {stylesheet.styleGoBack}>
							Go Back 
						</Text>
					</View>
				</View>
			</View>
		</ScrollView>
	)
}
const stylesheet = StyleSheet.create({
 	styleCaptainJacobBarrettPlane2DepartureDateTimeTomorrow100SexMaleUssocomUsasoc75rr375: {
		position: "absolute",
		left: 34,
		top: 39,
		width: 284,
		color: "rgba(0, 0, 0, 1)",
		fontSize: 16,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.30000000000000004,
		fontStyle: "normal",
		fontWeight: "700",
		textAlign: "left",
		height: "auto",
		lineHeight: 18.8,
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
		left: 0,
		top: 212,
		width: 126,
		height: 40,
	},
	styleStylename: {
		position: "relative",
		width: Dimensions.get("window").width,
		height: 252,
		backgroundColor: "rgba(255, 255, 255, 1)",
	},

});