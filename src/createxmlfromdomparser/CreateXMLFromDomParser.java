/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createxmlfromdomparser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Aga
 */
public class CreateXMLFromDomParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.newDocument();
        // создаем элементы документа и указываем какие из них будут дочерними
        // а также добавляем атрибуты элементам
        Element marketEl = doc.createElement("Магазин");
        doc.appendChild(marketEl);                           //метод добавления дочерниго элемента к элементу
        Element departmentEl = doc.createElement("Отдел");  
        Attr attrDepartment = doc.createAttribute("id");                     // Создаем аттрибут id для department элемента
        attrDepartment.setValue("Хозтовары");        // указываем значени аттрибута id 
        departmentEl.setAttributeNode(attrDepartment);     // присваиваем нужному элементу нужный аттрибут
        marketEl.appendChild(departmentEl);        
        Element productEl = doc.createElement("Продукт");
        Attr attrProduct = doc.createAttribute("id");
        attrProduct.setValue("Моющее средство");
        productEl.setAttributeNode(attrProduct);
        departmentEl.appendChild(productEl);
        Element titleEl = doc.createElement("Название");
        titleEl.appendChild(doc.createTextNode("Ферри"));  // создаем текстовый node. Строка, между тегами <title></title> в XML
        productEl.appendChild(titleEl);
        Element priceEl = doc.createElement("Цена");
        priceEl.appendChild(doc.createTextNode("120 рублей"));
        productEl.appendChild(priceEl);
        Element amountEl = doc.createElement("Количество");
        amountEl.appendChild(doc.createTextNode("20"));
        Attr attrAmount = doc.createAttribute("type");
        attrAmount.setValue("шт");
        amountEl.setAttributeNode(attrAmount);
        productEl.appendChild(amountEl);
        /*Структура сформирована*/
    }

}
