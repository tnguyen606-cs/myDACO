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
export const Page_styleTransferLoadPersonnelOverla = ({ route, navigation }) => {
	const { signIn, signOut, signUp, authData , resetPassword} = useAuth();
	return (
		<ScrollView style={{width: Dimensions.get("window").width, height: Dimensions.get("window").height, backgroundColor: "rgba(255, 255, 255, 1)"}} horizontal = {false} showsVerticalScrollIndicator={false} showsHorizontalScrollIndicator={false} bounces={false}>
			<View style={{width: Dimensions.get("window").width, height: 171}} >
				<View style = {stylesheet.styleStylename}>
					<Text style = {stylesheet.styleSelectTheNewManifestToAssignJohnDoeTo_}>
						Select the new manifest to assign John Doe to.
					</Text>
					<Text style = {stylesheet.styleConfirm}>
						Confirm
					</Text>
					<Text style = {stylesheet.styleCancel}>
						Cancel
					</Text>
					<View style = {stylesheet.styleDropdown}>
						<Image style = {stylesheet.styleIconsExpandArrow3} source = {{uri: "https://nyc3.digitaloceanspaces.com/sizze-storage/media/images/QBWHABMaYg6TysZjcvcDXmNl.png"}}/>
						<View style = {stylesheet.styleRectangle11}>
						</View>
						<Text style = {stylesheet.stylePlane2Manifest}>
							Plane 2 Manifest
						</Text>
					</View>
				</View>
			</View>
		</ScrollView>
	)
}
const stylesheet = StyleSheet.create({
 	styleSelectTheNewManifestToAssignJohnDoeTo_: {
		position: "absolute",
		left: -1,
		top: 18,
		width: 402,
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
	styleConfirm: {
		position: "absolute",
		left: 312,
		top: 136,
		width: 77,
		color: "rgba(26, 113, 215, 1)",
		fontSize: 20,
		fontFamily: "Arial_400Regular",
		letterSpacing: 0.5,
		fontStyle: "normal",
		fontWeight: "400",
		textAlign: "center",
		height: "auto",
		lineHeight: 23.4,
	},
	styleCancel: {
		position: "absolute",
		left: 207,
		top: 136,
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
	styleIconsExpandArrow3: {
		position: "absolute",
		left: 295,
		top: 6,
		borderRadius: null,
		width: 28,
		height: 28,
	},
	styleRectangle11: {
		position: "absolute",
		left: 0,
		top: 0,
		width: 331,
		height: 39,
		borderWidth: 0.5,
		borderColor: "rgba(0, 0, 0, 1)",
	},
	stylePlane2Manifest: {
		position: "absolute",
		left: 83,
		top: 8,
		width: 155,
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
	styleDropdown: {
		position: "absolute",
		left: 41,
		top: 77,
		width: 331,
		height: 39,
	},
	styleStylename: {
		position: "relative",
		width: Dimensions.get("window").width,
		height: 171,
		backgroundColor: "rgba(255, 255, 255, 1)",
	},

});