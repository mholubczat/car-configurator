package com.example.carconfigurator.creator;

import com.example.carconfigurator.engine.Car;
import com.example.carconfigurator.engine.EEngineType;
import com.example.carconfigurator.engine.Engine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CarOfferImpl implements CarOfferCreator {

    private static final String EMPTY_VALUE = "-";

    @Value("${offer.header:#(null)}")
    private String offerHeader;

    @Value("${offer.footer:#(null)}")
    private String offerFooter;

    @Override
    public String createCarOffer(Car car) {

        StringBuilder stringBuilder = new StringBuilder();

        if(offerHeader!=null){
            stringBuilder.append("\n");
            stringBuilder.append(offerHeader);
        }
        stringBuilder.append("\nNazwa: ");
        stringBuilder.append(car.getName());

        stringBuilder.append("\nKolor: ");
        stringBuilder.append(car.getColor());

        stringBuilder.append("\nKoła: ");
        stringBuilder.append(car.getWheelsSize());

        stringBuilder.append("\nSilnik: ");
        stringBuilder.append(car.getEngine());
        if(offerFooter!=null){
            stringBuilder.append("\n");
            stringBuilder.append(offerFooter);
        }
        return stringBuilder.toString();
    }


    public String createEngineDescription(Engine engine) {

        StringBuilder stringBuilder = new StringBuilder();

        if(engine==null){
            return EMPTY_VALUE;
        }
        stringBuilder.append("\nTyp: ");
        stringBuilder.append(engine.getType());

        stringBuilder.append("\nNazwa: ");
        stringBuilder.append(engine.getName());

        stringBuilder.append("\nMoc [KM]: ");
        stringBuilder.append(engine.getHorsepower());

        stringBuilder.append("\nSkrzynia biegów: ");
        stringBuilder.append(engine.getTransmission());

        stringBuilder.append("\nPojemność: ");
        stringBuilder.append(engine.getCC());


        return stringBuilder.toString();
    }

    private String mapEngineType(EEngineType type){
        if (type==null){
            return EMPTY_VALUE;
        }
switch(type){
    case DIESEL: return "Diesel";
    case PETROL: return "Benzyna";
}
        return EMPTY_VALUE;
    }

}
