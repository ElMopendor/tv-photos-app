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

- **[ X ] Initial Display** <br />

    - [ X ] On launching the app, display a grid of randomly selected photos from Unsplash. <br />
    - [ X ] Utilize the following API for fetching random photos:Unsplash API - Get a Random Photo 
        (https://unsplash.com/documentation#get-a-random-photo)<br />

<br />
        
![image](https://drive.google.com/uc?export=view&id=1Cpv5KFeoJo4Y5uzFeGxSRYwEmi_gGtr-)

<br />

- **[ X ] Photo Cards** <br />

    - Each card displayed should include: <br />
    - [ X ] The date the photo was created (`created_at`). <br />
    - [ ● ] *Up to three tags describing the photo *
        *Description task: Tags are not provided in json, so I put the name of the creator and the photo description instead of tags.*


- **[ X ] Infinite Scrolling**  <br />

    - Each card displayed should include: <br />
    - [ X ] As the user scrolls down, dynamically load the next set of photo thumbnails. <br />
    - [ X ] Use a placeholder image (e.g., an empty gray box) if the photo is still loading. <br />
    - [ X ] Ensure smooth scrolling and efficient memory management. <br />

<br />

![image](https://drive.google.com/uc?export=view&id=1S99ArIo_g2PA4TOenTvdqKYwC2TACZNb)

<br />

- **[ X ] Search Functionality**  <br />

    - [ X ] Users can type a tag into the search field or use voice search. <br />
        - [ X ] search field <br />
        - [  ] voice: I need more research to do this assignment  <br />
    - [ X ] Upon executing a search, query the Unsplash API to display relevant photos using this
            endpoint: Unsplash API - Search Photos
            (https://unsplash.com/documentation#search-photos), with the query parameter set to
            the user's input. <br />
        - [ ● ] *I didn't use that endpoint because it doesn't have the option to send queries, instead I used the /photos/random endpoint* <br />        
    - [ X ] Replace the main grid with the search results as depicted in Mockup 2. <br />

<br />

![image](https://drive.google.com/uc?export=view&id=1vNr3FH2GT3FgMvKmySoJSEFxv9EXemNP)

<br />

- **[ X ] Alternate Search via Unsplash API:** <br />

    - [ X ] Post-search, use the Unsplash API to fetch and display results on a refreshed mainpage. <br />
        - [ ● ] *It happens when the user presses inside the logo.* <br />
    - [ X ] Update the page title to reflect the searched term. <br />
    - [ X ] Display "No search results for <search term>" if no results are found. <br />

<br />

![image](https://drive.google.com/uc?export=view&id=19pSxVo4Q_mSkUjiCk9XRXHPcmVriICzt)

<br />
    
- **[ X ] Aditional Requirements:** <br />

    - [ X ] Utilize only the native Android framework, standard androidx libraries, and networking libraries like Retrofit. <br />
    - [ X ] Consider variable photo card sizes to accommodate different aspect ratios from Unsplash, or alternatively crop photos to fit a uniform card size. <br />
    - [ X ] Submit the final source code and an APK file for installation on an Android TV box. <br />
        - [ ● ] *It can be found in this* [drive link](https://drive.google.com/drive/folders/1GwqsLzS8_pBTgV-PgVMZDKdfuuUx6vFg?usp=drive_link)  <br />
    - [ X ] Quality and organization of the code will be a significant factor in the assessment. <br />
        - [ ● ] *I tried to do my best with a good folder structure* <br />

<br />

![image](https://drive.google.com/uc?export=view&id=1w9PqnUUm1sAFM7ZcR9S-SmrOxvMByz4V)

<br />


- **[ X ] To RUN the app:** <br />

    - Don´t forget to change the client_id in dev.properties
</pre>
<br />

![image](https://drive.google.com/uc?export=view&id=16jyzqt668HucYq9pqveMCF-z9L41oN2S)

<br />

**That's all!! Thank you for whatching.**
