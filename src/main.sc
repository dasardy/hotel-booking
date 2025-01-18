require: functions.js
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
            script:
                var city = $entities[0].value;
                $reactions.answer("Вы ввели:" + city);
                var hotels_list = fetch_hotels_by_city(city);
                $reactions.answer("Вы ввели:" + hotels_list.data.hotels[0].name);
            
        
        
