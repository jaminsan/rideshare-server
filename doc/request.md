### 乗客
- 外で車両を待ちたくない
    - 車両がいつ到着するかわからないため外でまっていることになってしまう
        - 車両の予想到着時刻を乗客が見れること
    - 車両がどこに来ていてどれくらいで到着するのかがわからないため外にでて待ってしまう
        - 乗客の予約が受理されて運行される場合は乗客が車両の現在位置を見れること
        - 車両が乗車地点に到着した際に乗客に通知されること
        - 車両の到着時間に変動がある場合は乗客に通知されること
- できるだけ安く乗りたい
    - 乗合をすることで少し遠回りしても良いので1人で乗るときよりは安く利用したい
        - 乗合をすることで料金が安くなる仕組みをいれること
        - 乗合が発生しやすい時間がわかればその時間に合わせて配車依頼を入れて帰りたい
            - 乗客が運行状況を閲覧できること
- できるだけ遠回りしたくない
    - 乗合で安く乗りたい一方で可能な限り乗車時間を減らしたい
        - 運行ルートは必要最小限のルートとすること
        - 車両が余計に遠回りしてないかどうかが気になるので車両のこれからの移動ルートを見たい
            - 乗客が車両の運行ルートを閲覧できること
- どんな人と乗り合うか不安なので乗合が発生する際には同乗者がどんな人なのか事前に確認したい
    - 事前に確認して不安があれば乗車をキャンセルしたい
        - 乗合発生時に乗合相手の情報を確認できること
        - 乗合相手をみて乗合したくない場合は乗車予定をキャンセルできること
    - 乗合した際に迷惑行為をした乗客がいれば次回以降乗合したくない
        - 乗合した乗客どうしで評価をつけられること
        - 乗合した相手をブラックリストに登録できること
        - ブラックリストの乗客とは次回の乗車から乗合するような運行をしないこと
- 電話予約が面倒なので手軽に呼びたい
    - 電話予約だと乗降地点を伝える際に住所を伝える必要があるのが面倒で伝えても認識がずれる可能性が大きく面倒である
        - 乗降地点を容易に入力できるインタフェースであること
    - スマホアプリなどで手軽に配車依頼できること
- 降車時刻には遅れないでほしい
    - 降車時刻を指定して配車依頼できること
    - 運行の降車時刻をオーバーする乗合や運行をしないこと
- 1人でも乗りたい
    - 安くならなくても良いので1人で乗りたい
        - 乗合可否を乗客が選択できること
        - 乗合不可の配車依頼に対しては乗合するような運行をしないこと
        - 乗合不可にした場合は乗合割引を適用しないこと
- 明日の朝など数日後の配車依頼をしたい
    - 明日絶対に使いたいのに当日予約してすぐに来てくれるかもわからないので事前に予約したい
        - 日時を指定して配車依頼できること
            - 数日先などの車両の稼働状況を管理できること
            - 車両の稼働状況を考慮して配車できること
        - 乗客は自分の配車依頼を閲覧できること
- クレジットカードで支払いしたい
    - 配車依頼時に支払い方法を入力できること
    - 乗客のクレジットカード情報を登録できること
    - 事前決済もできること
- よく行く場所を登録したい
    - お気に入りの場所を登録できること
    - 配車依頼時にお気に入りの場所から乗降地点を選択できること
- 領収書を発行したい
    - 運行記録を記録できること
    - 運行料金を記録できること
    - 運行記録から領収書を発行できること
- 行きと帰りの予約がしたい
    - 配車依頼を複数作成できること
    - 乗客が配車依頼を閲覧できること

### ドライバー
- 運行の遅延を減らしたい
    - スムーズにランデブーしたい
        - ドライバーが運行情報を閲覧できること
        - 運行情報から乗客の情報を閲覧できること
        - ドライバーの顔写真を乗客が閲覧できること
        - 車両の番号など車両を探しやすくなるような情報を乗客が閲覧できること
        - 乗車地点が停車しづらいところだった場合に少し場所をずらして停車したい
            - 乗車地点が変更になったことを乗客に伝えたい
        - 道路の右左どちらの車線にいるのかがずれてしまうとランデブーできなくなる
            - 配車依頼時に乗降地点を正しく入力できるインタフェースであること
            - GPS の精度を可能な限りあげること
    - 降車時の支払いをスムーズにしたい
        - 乗車料金の支払いは事前決済とすること
        - 乗降地点が複数あるのでどの乗客を乗降させるのか戸惑ってしまいそう
            - 乗客が乗降したことをシステムに知らせる操作は簡易なインタフェースであること
            - どの乗客がどこで降りるのかを顔写真などから容易に判断できること
    - 乗客の現在位置がわかれば乗車地点からずれていても近くに行くことができる
        - いちいちオペレータ経由で乗客とやりとりしていては時間がかかりすぎる上に情報のロスも多い
        - 乗客の任意で乗客の現在位置をドライバーが閲覧することができる
            - 常に見えていると乗客の動きをトラッキングできてしまう点を解消したい
- 運行ルートに詳しくないので案内してほしい
    - 車両が移動すべき最短のルートをドライバーが閲覧できること
    - ルートを外れた場合は自動的にルートを計算し直すこと
- だいたいの到着時間しか伝えられないので少しでも遅れると不満をいわれてしまう
    - 乗車時刻が遅れる場合は乗客に通知が行くこと
    - 乗客への予想到着時刻は余裕を見た時刻を伝えること
    - 配車時には乗降時刻に対してバッファを儲けて信号待ちなどの多少の誤差を盛り込むこと
        - 誤差を盛り込みすぎると乗客の待ち時間を増やしてしまうことになる
        - すでに乗客が乗っているさいに他の乗客を待っている時間が長くなってしまう

### オペレータ
- 遅延などの運行状況を知りたい
    - 運行情報を閲覧できること
    - 車両の現在位置を閲覧できること
    - 車両に割り当てられている配車依頼を閲覧できること
    - 遅延している車両を検索できること
    - 遅延している車両がわかりやすいインタフェースであること
    - 遅延している場合はドライバーにもわかること
- ドライバーへの送迎指示などを減らしたい
    - 配車依頼があった場合は自動で車両に割り当てられること
    - 運行が車両に自動で通知されること
    - ドライバーは割り当てられた運行を閲覧できること
    - 運行の異常時はドライバーとオペレータがスムーズに連絡を取り合えるインタフェースであること    
- 配車を簡単に最適化したい
    - 人手で配車を決めるのは時間がかかり次々配車依頼がきても人手ですぐ対応するのは難しい
        - 配車依頼が来たら自動で車両に割り当てられること
    - 色々な指標をバランスよく最適化した配車をしたい
        - 乗客の乗降時間の要望を満たすような配車ができること
            - 降車時刻に遅れないこと
                - サービスを利用してもらえなくなる
        - 車両の総走行距離が最小になるような配車ができること
            - 燃料費を抑えたい
        - 乗客の待ち時間が最小になるような配車ができること
            - サービスレベルをあげたい
        - 乗車率をできるだけ高くすること
            - 乗合をして効率よく乗客を送迎したい
        - 安くすることでより多くの人に使って欲しい
            - できるだけ乗合をするような運行にすること
- 需要の有無で車両の稼働を調整したい
    - 車両の稼働状態を切り替えられること
        - 需要がない時間帯には車両を減らして少ない車両で乗り合わせる
        - 需要が多い場合は車両が不足するため増やす
    - 車両の増減があった際に運行を再計算できること
        - 車両の過不足によって過度に配車が遅くなったりしている状況を解消したい
            - すでに乗客に乗降時間が伝わってしまっている場合はどうするか
- 定期運行便もやりたい
    - オンデマンドと定期運行を混ぜた運行ができること
        - 定期運行で不足した分をオンデマンドで補う
- 満車状態にならずに稼働状態をできるだけ高めたい
    - 車両の乗車率を調整できること
- 遅延している運行を変更したい
    - すごく遅れそうならキャンセルして車両を増やして再度予約するなどしたい
    - 車両を増やして再割り当てしたい
- 乗合の敷居を下げたい
    - 料金が安くなるなら利用してみようというきっかけになるかも
        - 乗合をすることで安くなるという仕組みがユーザに伝わりやすいインタフェースであること
        - 通常料金やメーター料金と割引後の料金を比較して表示することで割引を実感しやすいインタフェースにすること


### その他
- スムーズなランデブーで遅延を減らしたい
- 自由な乗降地点を入力されると車両が行きづらく運行しづらいので制限をかけられること
- 乗客の待ち時間を最小にしたい
- 乗客の乗車時間を最小にしたい
- ドライバーのルートが急に変わると対応できないので直近の乗降ルートは変更しないこと（特に、次の乗降地点までの時間に猶予がない場合）
    - まだ乗車してなくて十数分先の予約を引っこ抜いて別車両に割り当てる
- 配車計算を自動化
- 大きい荷物を持った乗客
- 酔っ払った乗客
- 道路渋滞
- 乗合相手に自分の家を知られたくない
- 貨客混載をしたい
- 荷物の配送も受け付けたい
- 仮想乗り場を用意したい
    - 乗客が好きな位置に乗降位置を指定できてしまうと車両が停まれる場所なのかどうかを把握したりするのが面倒なのであらかじめ運営側が指定した場所しか選べないようにしたい
    - 右車線、左車線どちらなのかというのも GPS が狂ったりするとめんどくさい
- 料金が安くなるということ以外の付加価値
- 空車状態の車両を高需要地点に移動させたい
- 電話でも予約できるようにする
- 事前決済だと乗合有無を想定した料金を事前に定時する必要がある
- 仮配車をするかどうか
- キャンセル料を取りたいので事前決済が良い
- 希望降車時刻と希望乗車時刻両方を入れるケース
- 乗車人数の変更
    - 予約変更申請
- サービス稼働時間
- 車両の稼働時間
- トイレ休憩
- ドライバーの昼休み
- 給油