require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Здравствуйте! Я виртуальный ассистент для поиска и бронирования отелей. Чем могу помочь?
        go: ChooseOperation
        
        
    state: ChooseOperation
        intent!: /поиск отелей
        a: Пожалуйста, введите город, в котором хотите найти отель.
        
        
        
    state: Hello
        intent!: /привет
        a: Привет привет

    state: Bye
        intent!: /пока
        a: Пока пока

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}
        
        
        
