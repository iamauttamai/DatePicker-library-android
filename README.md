# DatePicker-library-android
 
![Screenshot_20230321_145754_DatePicker](https://user-images.githubusercontent.com/112051173/226549862-4314a913-d4a1-4a33-8021-8934ec67e6d6.jpg) 
![Screenshot_20230321_150002_DatePicker](https://user-images.githubusercontent.com/112051173/226550375-be4a7c95-cbd6-41fe-8e01-3ed6b1f88c76.jpg)
 
 ### Gradle
**Step 1** Add the JitPack repository to your build file. Add it in your build.gradle at the end of repositories.

```java
  repositories {
    maven { url "https://jitpack.io" }
  }
```

**Step-2** Add the dependency in the form

```java
dependencies {
    implementation 'com.github.iamauttamai:DatePicker-library-android:1.0.9'
}
```

## Using

 -  In Java
```java
new DatePicker(this)
     .setTitle("Select date")
     .setConfirm("Confirm")
     .setTitleColor(Color.parseColor("#005DA8"))
     .setTitleSize(10f)
     .setStartYear(1998)
     .setEndYear(2050)
     .create(new PickerCallBack() {
         @Override
         public void data(@NonNull Date response) {
             // Response Type Date Data
         }
     });
```
  -  In Kotlin
```kotlin
DatePicker(this)
    .setTitle("Select date")
    .setConfirm("Confirm")
    .setTitleColor(Color.parseColor("#005DA8"))
    .setTitleSize(10f)
    .setStartYear(1998)
    .setEndYear(2050)
    .create(object : PickerCallBack {
        override fun data(data: Date) {
            // Response Type Date Data
        }
     })
```
  

### Maven
```xml
<repository>
     <id>jitpack.io</id>
     <url>https://jitpack.io</url>
</repository>
```



