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
            q: * @pymorphy.geox *
            script:
                $session.city = $entities[0].value;
                $reactions.answer("Вас понял. Ищем отели в городе " + $session.city);
                $reactions.answer("Пожалуйста, выберите один из трёх типов сортировки: \n 1.Сортировка по рейтингу \n 2.Сортировка по релевантности. \n 3.Сортировка по алфавиту.");
                # var hotels_list = fetch_hotels_by_city($session.city);
                # $reactions.answer("Вы ввели:" + hotels_list[0].name);
            go: ChooseSortType
            
            
            state: ChooseSortType
                q: * @duckling.number | @duckling.ordinal *
                script: 
                    $session.sort_type = $entities[0].value;
                    $reactions.answer("Вы выбрали сортировку номер " + $session.sort_type + ".");
                
                
        
            
        
        
