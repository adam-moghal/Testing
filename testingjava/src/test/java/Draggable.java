import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Draggable {
    @FindBy ( css = "#draggable")
    WebElement draggable;

    @FindBy(css = "#slider-range-max > span")
    WebElement slider;

    @FindBy(css = "#ui-id-2" )
     WebElement constrainmovementLink;

    @FindBy(css = "#ui-id-5" )
    WebElement draggableSortableLink;


    @FindBy(css = "#draggabl")
    WebElement constrainedX;


    @FindBy(css = "#draggabl2")
    WebElement constrainedY;

    @FindBy(css = "#sortablebox > li:nth-child(1)")
    WebElement item1Draggable;

    @FindBy(css = "#sortablebox > li:nth-child(2)")
    WebElement item2Draggable;

    @FindBy(css = "#draggablebox")
    WebElement dragMeDownDraggable;

   public void clickConstrainMovementLink(){
        constrainmovementLink.click();
   }

   public void clickDraggableSortableLink(){

       draggableSortableLink.click();
   }
    public int getDraggableX() {
        return draggable.getLocation().x;
    }

    public int getDraggableY() {
        return draggable.getLocation().y;
    }

}
