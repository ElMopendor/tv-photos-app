Take-Home Assignment: Android TV “Photo Search” App




I made a video of the assignment result

[![Watch the video](https://drive.google.com/uc?export=view&id=14z2m90TgeeT81xqkTCIQ_eSgcH1M8ri-)](https://drive.google.com/file/d/1GBKsG-0TH1J29WpFICwxGAKOJ-h2ynTA/view?usp=sharing)


**==> TODOS**

**[ X ] Initial Display**
    [ X ] On launching the app, display a grid of randomly selected photos from Unsplash.
    [ X ] Utilize the following API for fetching random photos:Unsplash API - Get a Random Photo 
        (https://unsplash.com/documentation#get-a-random-photo)
        
![image](https://drive.google.com/uc?export=view&id=1eiHSXYCxTtbvIJ4gPxIvZOOZXOuWD_Zp)

**[ X ] Photo Cards**
    Each card displayed should include:
    [ X ] The date the photo was created (`created_at`).
    [ ● ] *Up to three tags describing the photo*
        *Description task: Tags are not provided in json, so I put the name of the creator and the photo description instead of tags.*

**[ X ] Infinite Scrolling**
    Each card displayed should include:
    [ X ] As the user scrolls down, dynamically load the next set of photo thumbnails.
    [ X ] Use a placeholder image (e.g., an empty gray box) if the photo is still loading.
    [ X ] Ensure smooth scrolling and efficient memory management.

![image](https://drive.google.com/uc?export=view&id=1S99ArIo_g2PA4TOenTvdqKYwC2TACZNb)
    
**[ X ] Search Functionality**
    [ X ] Users can type a tag into the search field or use voice search.
        [ X ] search field
        [  ] voice: I need more research to do this assignment
    [ X ] Upon executing a search, query the Unsplash API to display relevant photos using this
            endpoint: Unsplash API - Search Photos
            (https://unsplash.com/documentation#search-photos), with the query parameter set to
            the user's input.
            [ ● ] *I didn't use that endpoint because it doesn't have the option to send queries, instead I used the /photos/random endpoint*
        
    [ X ] Replace the main grid with the search results as depicted in Mockup 2.

![image](https://drive.google.com/uc?export=view&id=1pIRYSAefMcKNoFB0BDU1DB0rGA8L17tk)

**[ X ] Alternate Search via Unsplash API:**
    [ X ] Post-search, use the Unsplash API to fetch and display results on a refreshed mainpage.
        [ ● ] *It happens when the user presses inside the logo.*
    [ X ] Update the page title to reflect the searched term.
    [ X ] Display "No search results for <search term>" if no results are found.

![image](https://drive.google.com/uc?export=view&id=19pSxVo4Q_mSkUjiCk9XRXHPcmVriICzt)

    
**[ X ] Aditional Requirements:**
    [ X ] Utilize only the native Android framework, standard androidx libraries, and networking libraries like Retrofit.
    [ X ] Consider variable photo card sizes to accommodate different aspect ratios from Unsplash, or alternatively crop photos to fit a uniform card size.
    [ X ] Submit the final source code and an APK file for installation on an Android TV box.
        [ ● ] *It can be found in this* [drive link](https://drive.google.com/drive/folders/1GwqsLzS8_pBTgV-PgVMZDKdfuuUx6vFg?usp=drive_link) 
    [ X ] Quality and organization of the code will be a significant factor in the assessment.
        [ ● ] *I tried to do my best with a good folder structure*

![image](https://drive.google.com/uc?export=view&id=1w9PqnUUm1sAFM7ZcR9S-SmrOxvMByz4V)



**That's all!! Thank you for whatching.**