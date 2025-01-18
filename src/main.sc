require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Здравствуйте! Я виртуальный ассистент для поиска и бронирования отелей. Чем могу помочь?

    state: SearchHotels
        intent!: /поиск отелей
        a: Пожалуйста, введите город, в котором хотите найти отель.
        
        state: ChooseCity
           q!: * @pymorphy.geox *
           a: Вы выбрали:
            
        
        
        
