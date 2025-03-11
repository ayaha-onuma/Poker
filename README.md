# 🃏 Poker Game (Java)

## 📌 概要
Javaで「クローズドポーカー（1回交換、5枚手札）」のルールに基づいたポーカーゲームを開発しました。  
**オブジェクト指向設計** を意識し、以下のように責務を分離しました：
- **プレイヤー管理**（Playerクラス）
- **カードデッキ管理**（Cardクラス）
- **役判定ロジック**（HandRankクラス）
- **順位決定ロジック**（Rankingクラス）
- **ゲーム進行管理**（Gameクラス）

また、UML図を用いてクラス構成を整理し、拡張性の高い設計を目指しています。


## 🎯 特徴
✔ **オブジェクト指向設計**  
   - プレイヤー、カード、役判定をクラス単位で設計し、役割を明確化  
✔ **ポーカー役の判定**  
   - ワンペア・ツーペア・フルハウス・ストレートなどを判定し、順位を決定  
✔ **拡張性**  
   - ルール変更やUI追加がしやすい設計  


## 🛠 使用技術
- **Java 17**
- **Eclipse**
- **UML（クラス図作成）**

📌 **UMLクラス図**

![dP5DRiCW48NtSufHLicY5_2YYfIswgvHVmw0OEIune06KDlRTuADYDjcKsziFZxUmx2FIN7AamMbasSy-f4OWh113q6vX6_n1pYSbEjfXLuvJs557fKppygDAtW6W-i1IWlUt9Rm3iqGWrLVvpKWH6PagZZDd5ixf4zTlWwAJOIPjgIUqZgbBfENQVQyuQBVaHwX35U-4VmhFVwTNhsswt_](https://github.com/user-attachments/assets/51fd662a-ab74-47ad-be51-ad364ee2c012)


![ZLEnZjGm4Etp5IvtjSfT7w7ef4M20WGwe48K9fxrcasSo1vBd61B2f1EegVcq_O_iEFSpIp9IfSYoepdlNdpFBdnA1s6hYrQsA70NZYZzoYKST2WwMrH3B8vI0r2omx4jqB4nrW4jvCDY1UKJCzcQENTQZt6n_7TjD9xSGlexbXTcSYg4KrObueuU8ALPPtxL6AYFvAgeJ-0YypKwx](https://github.com/user-attachments/assets/cb16c5f1-7643-4ea1-82e9-ca1bac7eb472)



## 🚀 今後の改善点
- 🏦 **掛け金システムの追加**（ベット機能）
- 🎨 **UIの実装**
  - **Webアプリ化（Spring Boot & Thymeleaf）** もしくは **JavaFX** の導入を検討中   
- 🌐 **オンライン対戦機能（将来的に）**
  - ソケット通信 or REST APIを使ったオンラインプレイ  



## 📥 インストール・実行方法
### 1. Javaをインストール
- [公式サイト](https://www.oracle.com/java/technologies/javase-downloads.html) からJava 17をダウンロードしてインストール

### 2. 本リポジトリをクローン

- git clone https://github.com/ayaha-onuma/Poker.git cd Poker


### 3. Javaをコンパイル

- javac Main.java


### 4. 実行
