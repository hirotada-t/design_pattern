## PlayfulPetsAdventures.java
ペットのレンタル、遊び方、請求書の出力を行います。
### クラス
- PlayfulPetAssistant
......抽象クラス。共通する処理を具象メソッドとして持ち、貸出ペットのインスタンス化を抽象メソッドで行います。
- Playful〇〇Assistant
......PlayfulAssistantを継承したサブクラス。ペットをインスタンス化するメソッドを実装します。
- FairyWorld
......上記Assistantに対応するHashMap、請求書、ペットのレンタルを実行します。
- PlayfulPet
......ペットで遊ぶために必要なメソッドをまとめたインターフェース。各種ペットのクラスに継承させます。
### 中心となるメソッド
- rentPet()
......人、ペットの種類、数、ツアーの種類を受け取ってランダムに遊びます。レンタルする度にInvoiceクラスで請求書の内容を更新します。
- getRentedPetsInvoice()
......現在の請求内容を返します。今までレンタルしたペットの内訳と合計金額を出力します。

## VirtualRides.java
遊園地でアトラクションに乗って遊びます。
### クラス
- RideExperience
......抽象クラス。アトラクションを実行する処理を具象メソッドとして持ち、アトラクションのインスタンス化を抽象メソッドで行います。
- Ride〇〇
......RideExperienceを継承したサブクラス。アトラクションをインスタンス化するメソッドを実装します。
- FairyWorld
......上記Attractionに対応するHashMap、アトラクションの利用を実行します。
- Attraction
......アトラクションに必要なメソッドをまとめたインターフェース。各種アトラクションのクラスに継承させます。
### 中心となるメソッド
- ride()
......人、アトラクションの名前を受け取って遊びます。身長の条件によって判別します。
