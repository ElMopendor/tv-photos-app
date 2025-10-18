# 📺 Android TV — Photo Search App

A native **Android TV** application that browses photos from **Unsplash**. It supports an initial random gallery, infinite scrolling with placeholders, and text-based search, all optimized for TV navigation and performance.

---

## 🎥 Demo Video

[![Watch the video](https://drive.google.com/uc?export=view&id=14z2m90TgeeT81xqkTCIQ_eSgcH1M8ri-)](https://drive.google.com/file/d/1GBKsG-0TH1J29WpFICwxGAKOJ-h2ynTA/view?usp=sharing)

---

## ✅ Scope & Checklist

### Initial Display
- [x] On launch, show a grid with randomly selected photos from Unsplash  
- [x] Uses **Unsplash API – Get a Random Photo**

![Initial grid](https://drive.google.com/uc?export=view&id=1Cpv5KFeoJo4Y5uzFeGxSRYwEmi_gGtr-)

### Photo Cards
- [x] Show `created_at` date on each card  
- [~] Up to three tags describing the photo  
  - _Note: The random endpoint doesn’t provide tags. As an alternative, the card shows the **author name** and the **photo description**._

### Infinite Scrolling
- [x] Dynamically load more thumbnails as the user scrolls  
- [x] Placeholder image while loading  
- [x] Smooth scrolling and efficient memory usage

![Infinite scroll](https://drive.google.com/uc?export=view&id=1S99ArIo_g2PA4TOenTvdqKYwC2TACZNb)

### Search Functionality
- [x] Text search field  
- [ ] Voice search (not implemented yet)  
- [x] Execute search against Unsplash and replace the main grid with results  
  - _Note: For consistency with random browsing and to allow seeded queries, the app uses the **/photos/random** endpoint strategy rather than `/search/photos`._

![Search results](https://drive.google.com/uc?export=view&id=1vNr3FH2GT3FgMvKmySoJSEFxv9EXemNP)

### Alternate Search Refresh
- [x] Post-search, refresh results on the main page (triggered when the user selects the logo)  
- [x] Update the page title to reflect the search term  
- [x] Show “No search results for <term>” when applicable

![No results](https://drive.google.com/uc?export=view&id=19pSxVo4Q_mSkUjiCk9XRXHPcmVriICzt)

### Additional Requirements
- [x] Only native Android framework, androidx libs, and a networking lib (Retrofit)  
- [x] Handle different aspect ratios or crop to a uniform card size  
- [x] Submit source code and **APK** for Android TV  
  - 📦 APK & assets: [Drive link](https://drive.google.com/drive/folders/1GwqsLzS8_pBTgV-PgVMZDKdfuuUx6vFg?usp=drive_link)  
- [x] Emphasis on code quality and organization  
  - _Structured packages and clear responsibility separation_

![Cards & layout](https://drive.google.com/uc?export=view&id=1w9PqnUUm1sAFM7ZcR9S-SmrOxvMByz4V)

---

## 🧰 Tech Stack

- **Platform:** Android TV (native)  
- **Language:** Kotlin  
- **UI:** AndroidX (RecyclerView/TV-friendly layout)  
- **Networking:** Retrofit + OkHttp  
- **Image Loading:** (e.g., Glide/Coil — according to implementation)  
- **Async:** Kotlin Coroutines / Flow  
- **Build:** Gradle (AGP)  

> The project follows a presentation/data separation with clear responsibilities, enabling smooth scrolling and memory safety.

---

## 🗂️ Project Structure (high level)

```
app/
  data/
    remote/        # Retrofit services, models (DTOs)
    repository/    # Data access layer
  domain/          # (Optional) Use-cases / models if applied
  ui/
    home/          # Initial random grid
    search/        # Search screen + title updates
    components/    # Adapters, view holders, decorators
  core/
    di/            # Dependency injection setup (if used)
    util/          # Helpers & extensions
```

---

## ⚙️ Configuration & Run

1) Add your Unsplash client id in `dev.properties`:
```
UNSPLASH_CLIENT_ID=YOUR_CLIENT_ID
```

2) Build & Install (Android TV target):
```
./gradlew assembleDebug
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

> Ensure your TV device/emulator is connected and visible via `adb devices`.

---

## 🧩 Notes & Limitations

- Tags are not available from the random endpoint; using author and description as a friendly alternative  
- Voice search is pending (future iteration)  
- The grid uses placeholders to avoid jank while images load  

---

## 👨‍💻 Author

**Luis Aguilar Rojas**  
Full Stack Engineer (Mobile Focused)  
[LinkedIn](https://linkedin.com/in/luis-angel-developer) • [GitHub](https://github.com/ElMopendor)

— Thanks for watching!
