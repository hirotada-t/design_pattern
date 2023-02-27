FairyWorldに、ミニ四駆を作って走らせるゲームコーナーを構築する。

## FairyWorldクラス
各メソッドを実行する
- createMini4WD()
- createCourse()
- raceMini4WD(mini4WD, course)

## RaceAssistantクラス
raceMini4WDメソッドの実装
Mini4WDとCourseを受け取って結果を返す

## Mini4WDFactoryインターフェース
各パーツの一覧
- ボディ（色）
- シャーシ（剛性）
- 電池
- モーター（出力/回転数/トルク）
- タイヤ（素材/グリップ）
- ローラー（オプション/設置する組み数/コーナーの安定感）
- サスペンション（オプション/レーンチェンジの安定感）

## 各種Mini4WDFactory（Abstract Factory）
インターフェースを実装
### 各種createParts（SimpleFactory）
オプションの有無を渡してMini4WDオブジェクトを返す
### 平坦に強いが登りだと遅いマシン
回転数が多い/トルクが弱い/コースアウト/コーナリング
### 登りに強いが平坦だと遅いマシン
回転数が少ない/トルクが強い

## Partsクラス
各パーツクラスが継承
重さ・価格の状態を持つ

## Mini4WD（FacrotyMethod）
各種完成車が継承
Specクラスを持つ抽象クラス
完成車のコスト・重量を計算

## 各種Mini4WDクラス
各種Mini4WDFactoryによって生成されるオブジェクト

## Specクラス
生成したパーツを受け取ってMini4WDの性能を返す

## コース
- Easy（ギミックなし/平坦）
- Straight（レーンチェンジ/平坦）
- Corner（レーンチェンジ/平坦/コーナー多数）
- Climbing（レーンチェンジ/登り）
- Hard（レーンチェンジ/登り/コーナー多数）

## createCourseクラス（Factory）
難易度の文字列を受け取ってコースを返す
引数なしでランダムなコースを返す
