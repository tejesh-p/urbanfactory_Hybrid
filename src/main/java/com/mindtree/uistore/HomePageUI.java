package com.mindtree.uistore;

import org.openqa.selenium.By;

public class HomePageUI {
	public static By search_bar = By.id("search");
	public static By search_button = By.id("search_button");
	public static By offer_alert = By.xpath("//div[@id='head-alert']/div/div");
	public static By header_profile = By.cssSelector(".header__topBarIconList_profile-icon");
	public static By Login = By.xpath("//a[@class='login-link authentication_popup']");
	public static By insta = By.xpath("//a[@data-gaaction='Click_Footer_Instagram']");
	public static By playapp = By.xpath("//div[@class='download-btns']/a[1]");
	public static By iOSapp = By.xpath("//div[@class='download-btns']/a[0]");
	public static By subscribe_input = By.id("email_id");
	public static By subscribe_btn = By.xpath("//a[@value='SUBSCRIBE']");
	public static By n_offers = By.xpath("//ul[@class='dots-on-slide']/li");
	public static By n_item_furniture = By.xpath("//div[@class=categories row]/a");
	public static By payment_method = By.xpath("//img[@class='we-accept']");
	public static By locations = By.xpath("//div[@class='footer_msg_text']/div[2]/ul/li");
	public static By subscribe_success = By.xpath("//div[@class='footer-email-subscribe']/div/div");
}
