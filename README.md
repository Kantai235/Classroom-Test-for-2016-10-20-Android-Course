# 10 / 20 [App程式設計] 課程小考
## 題目要求：
###### (1) 製作三個頁面，首頁必須有 TextView、ImageButton、ImgaeView。
###### (2) 在首頁上點擊 ImageButton、ImgaeView 可以跳到其他兩個頁面。
###### (3) 跳到 ImageButton 的頁面，會 Show 出標題、教學影片、返回按鈕。
###### (4) 教學影片讀取 Local 端的影片。
###### (5) 跳到 ImageView 的頁面，會 Show 出 About Me 的相關資訊。

![題目要求](/images/topic.jpg "題目要求")

### ！注意！
本專案是使用 [Android-Bootstrap](https://github.com/Bearded-Hen/Android-Bootstrap "Android-Bootstrap") 完成的，可以去參考一下 ( 不過本專案有不少東西都是套用這框架 )。

首先拉一拉首頁，大概會長這樣：

![首頁](/images/mainView.png "首頁")

然後建立其他分頁：

![Docker View](/images/dockerView.png "Docker View")

![About Me View](/images/aboutMeView.png "About Me View")

為了讓首頁當中的 ImageButton、ImgaeView 被點擊能夠換頁，所以必在 xml 對應的元件上加入 onClick 事件：

```XML
android:onClick="mainClick"
```

然後在首頁的 .java 當中去建立事件，並且寫入換頁的方法：

```Java
public void mainClick(View view) {
    Intent intent = new Intent();
    switch (view.getId()) {
        case R.id.mainImageButton:
            intent.setClass(this, dockerView.class);
            break;

        case R.id.mainImageView:
            intent.setClass(this, aboutMeView.class);
            break;
    }
    startActivity(intent);
    finish();
}
```

再來程式如果進入 Docker 頁面時，必須顯示一個影片，並執行影片，所以在 Docker 的 .java 當中，我們必須引入 VideoView，並且引入影片的來原：

```Java
// 引入 VideoView 元件
VideoView videoView = (VideoView) this.findViewById(R.id.videoView);
// 建立 Media 控制元件
MediaController mc = new MediaController(this);
// 賦予 VideoView 控制元件
videoView.setMediaController(mc);
// 本次用 Project 下的目錄作為路徑來示範
videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video));
// 對影片做加載
videoView.requestFocus();
// 開始播放
videoView.start();
```

然後 callBack 的方法就仿造首頁換頁的方法即可。
