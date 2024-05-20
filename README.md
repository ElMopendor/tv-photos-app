### Take-Home Assignment: Android TV “Photo Search” App<br />
<br />
<br />
<br />



## I made a video of the assignment result<br />
<br />

[![Watch the video](https://drive.google.com/uc?export=view&id=14z2m90TgeeT81xqkTCIQ_eSgcH1M8ri-)](https://drive.google.com/file/d/1GBKsG-0TH1J29WpFICwxGAKOJ-h2ynTA/view?usp=sharing)

<br />

## ==> TODOS <br />

<br />

**[ X ] Initial Display** <br />
&emsp    [ X ] On launching the app, display a grid of randomly selected photos from Unsplash. <br />
&emsp    [ X ] Utilize the following API for fetching random photos:Unsplash API - Get a Random Photo 
          (https://unsplash.com/documentation#get-a-random-photo)<br />
        
![image](https://drive.google.com/uc?export=view&id=1eiHSXYCxTtbvIJ4gPxIvZOOZXOuWD_Zp)

<br />

**[ X ] Photo Cards** <br />
&emsp    Each card displayed should include: <br />
&emsp     [ X ] The date the photo was created (`created_at`). <br />
&emsp&emsp     [ ● ] *Up to three tags describing the photo *
         *Description task: Tags are not provided in json, so I put the name of the creator and the photo description instead of  tags.*

**[ X ] Infinite Scrolling**  <br />
&emsp     Each card displayed should include: <br />
&emsp     [ X ] As the user scrolls down, dynamically load the next set of photo thumbnails. <br />
&emsp     [ X ] Use a placeholder image (e.g., an empty gray box) if the photo is still loading. <br />
&emsp     [ X ] Ensure smooth scrolling and efficient memory management. <br />
<br />

![image](https://drive.google.com/uc?export=view&id=1S99ArIo_g2PA4TOenTvdqKYwC2TACZNb)
<br />

**[ X ] Search Functionality**  <br />
&emsp     [ X ] Users can type a tag into the search field or use voice search. <br />
&emsp&emsp         [ X ] search field <br />
&emsp&emsp         [  ] voice: I need more research to do this assignment  <br />
&emsp     [ X ] Upon executing a search, query the Unsplash API to display relevant photos using this
            endpoint: Unsplash API - Search Photos
&emsp             (https://unsplash.com/documentation#search-photos), with the query parameter set to
             the user's input. <br />
&emsp&emsp             [ ● ] *I didn't use that endpoint because it doesn't have the option to send queries, instead I used the /photos/random endpoint* <br />        
&emsp     [ X ] Replace the main grid with the search results as depicted in Mockup 2. <br />
 <br />
 
 ![image](https://drive.google.com/uc?export=view&id=1pIRYSAefMcKNoFB0BDU1DB0rGA8L17tk)
 <br />
 
 **[ X ] Alternate Search via Unsplash API:** <br />
&ensp     [ X ] Post-search, use the Unsplash API to fetch and display results on a refreshed mainpage. <br />
&ensp&ensp         [ ● ] *It happens when the user presses inside the logo.* <br />
&ensp     [ X ] Update the page title to reflect the searched term. <br />
&ensp     [ X ] Display "No search results for <search term>" if no results are found. <br />
 
 <br />
 
 ![image](https://drive.google.com/uc?export=view&id=19pSxVo4Q_mSkUjiCk9XRXHPcmVriICzt)
 <br />
     
 **[ X ] Aditional Requirements:** <br />
&emsp     [ X ] Utilize only the native Android framework, standard androidx libraries, and networking libraries like Retrofit. <br />
&emsp     [ X ] Consider variable photo card sizes to accommodate different aspect ratios from Unsplash, or alternatively crop photos to fit a uniform card size. <br />
&emsp     [ X ] Submit the final source code and an APK file for installation on an Android TV box. <br />
&emsp&emsp         [ ● ] *It can be found in this* [drive link](https://drive.google.com/drive/folders/1GwqsLzS8_pBTgV-PgVMZDKdfuuUx6vFg?usp=drive_link)  <br />
&emsp     [ X ] Quality and organization of the code will be a significant factor in the assessment. <br />
&emsp&emsp         [ ● ] *I tried to do my best with a good folder structure* <br />
 <br />
 
 ![image](https://drive.google.com/uc?export=view&id=1w9PqnUUm1sAFM7ZcR9S-SmrOxvMByz4V)
 
 <br />
 
 **That's all!! Thank you for whatching.**
