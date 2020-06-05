// http://www.apache.org/licenses/LICENSE-2.0

package beka;

import android.os.Build;
import android.support.v4.content.FileProvider;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import beka.helpers.Animal;
import com.google.appinventor.components.runtime.*;

@DesignerComponent(version = 1,
   description = "This is my custom zoo component",
   category = ComponentCategory.EXTENSION,
   nonVisible = true,
   iconName = "images/extension.png")
@SimpleObject(external = true)
public class Zoo extends AndroidNonvisibleComponent {

  private Animal favoriteAnimal = Animal.Lion;
  //private String favoriteAnimal;

  public Zoo(ComponentContainer container) {
    super(container.$form());
  }

  @SimpleProperty(
    description="The favorite animal at the zoo."
  )
  /**
   * Get the zoo's favorite animal.
   */
  public String FavoriteAnimal() {
    return favoriteAnimal.getValue();
    //return favoriteAnimal;
  }

  @DesignerProperty(
    editorType=PropertyTypeConstants.PROPERTY_TYPE_INTEGER,
    defaultValue="1"
  )
  @SimpleProperty
  /**
   * Set the given animal as the zoo's favorite.
   */
  public void FavoriteAnimal(String animal) {
    favoriteAnimal = Animal.get(animal);
    //favoriteAnimal = animal;
  }

  @SimpleFunction(
    description="Make the animal dance."
  )
  /**
   * Make the given animal dance.
   */
  public void MakeDance(String animal) {

  }

  @SimpleEvent(
    description="An animal has just become hungry!"
  )
  /**
   * Fired when an animal is hungry.
   */
  public void OnHungry(String animal) {
  }
}
