FairyWorld にはおもちゃ屋さんがある
与えられたキット（道具一式）で自分のおもちゃを作る

## キットにはテーマに沿ったおもちゃを作るパーツが付属
ex.)
Cyber Vampire キット
- 牙と目が光る頭（牙を動かすスイッチ）
- 黒いマントを被った胴体（背中にコウモリの音が鳴るスイッチ）
- 爪を持った左腕
- 血の入ったコップを持った右腕
- 冷血な二本の脚

## createAHumanoidToyByKit() メソッドを設計
HumanoidToyKitFactory を受け取る
## HumanoidToyKitFactory（Abstract Factory）
人型のおもちゃを作るために必要な全てのメソッドを含む
ex.)
robot、vampires、werewolf、transformer、alien など

## 人型のおもちゃ
頭、胴体、左腕、右腕、左足によって構成
Factory によって、目、手、足も指定できる
各おもちゃは、「音を出す」、「歩く」等の機能を持つ
マイクロチップや回路基板、電池などが必要

## 各部品
組み立て難易度の指標
おもちゃを取り扱う子供の年齢に影響
ex.)ある部品を5歳児が扱う場合、親の補助が必要など

## Profuctインターフェースの実装
すべての部品に getCosts() メソッドを実装
おもちゃが完成するとPersonに一定の金額を請求する