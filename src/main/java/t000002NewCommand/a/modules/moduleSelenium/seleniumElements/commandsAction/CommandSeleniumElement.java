package t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import t000002NewCommand.a.core.ICommand;


import t000002NewCommand.a.modules.moduleSelenium.IAppGetableDriver;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.ISeleniumElement;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction.expression.Expression;

public abstract class CommandSeleniumElement implements ICommand {

    protected static Logger logger = LoggerFactory.getLogger(CommandSeleniumElement.class);

    protected long waitingTimeMillis = 5000;
    protected long deltaToWaitMillis = 250;

    protected IAppGetableDriver appSeleniumElement;
    protected ISeleniumElement seleniumElement;

    public CommandSeleniumElement(IAppGetableDriver appSeleniumElement, ISeleniumElement seleniumElement) {
        this.appSeleniumElement = appSeleniumElement;
        this.seleniumElement = seleniumElement;
    }

    protected <T> T waitingAction999 (Expression<T> func, IAppGetableDriver appSeleniumElement, long waitingTimeMillis, long deltaToWaitMillis) {
        return waitingAction999(func, appSeleniumElement, waitingTimeMillis, deltaToWaitMillis, true);
    }

    protected <T> T waitingAction999 (Expression<T> func, IAppGetableDriver appSeleniumElement, long waitingTimeMillis, long deltaToWaitMillis, boolean isPrintStackTrace) {

        T returnParametr = null;


        long waitingTimeMillisLeft = waitingTimeMillis;
        // точное время
        long startTime = System.nanoTime();
        long prevTime = startTime;

//        if (appSelenium.getSettingsOfTest().getLogSettings().isLogAction()) {
//            // если нужно то логируем
//            logger.info("[" + logTypeOfAction + " [Общ:" + Long.toString(waitingTimeMillis) +
//                    "Ост:" + Long.toString(waitingTimeMillisLeft) + "Инт:" + Long.toString(deltaToWaitMillis) +
//                    "] [\"" + seleniumElement.getElementFullName() + "\"] с XPath=" + seleniumElement.getElementFullXpath());      //---debug---
//        }

        boolean wait = true;    // нужно ли выполнять действия
        boolean timeoutException = false;       // время нажатия вышло
        while (wait) {
            try {
//                returnParametr = func.doAction(appSelenium.getDriver().getDriver().findElement(By.xpath(seleniumElement.getElementFullXpath())));
                returnParametr = func.doAction(appSeleniumElement.getDriver().findElement(By.xpath(seleniumElement.getElementFullXpath())));
//                if (appSelenium.getSettingsOfTest().getLogSettings().isLogAction()) {
//                    // если нужно то логируем
//                    logger.info("[" + logTypeOfAction + " [Общ:" + Long.toString(waitingTimeMillis) +
//                            "Ост:" + Long.toString(waitingTimeMillisLeft) + "Инт:" + Long.toString(deltaToWaitMillis) +
//                            "] [\"" + seleniumElement.getElementFullName() + "\"] с XPath=" + seleniumElement.getElementFullXpath());      //---debug---
//                }
                wait = false;
                break;
            } catch (Exception ex1) {
                // проработать различные Exception (forFast, not use method)
                // в зависимости от Exception можно использовать isCashed для ускорения
                // WebDriverException (общий метод)
                // ElementNotVisibleException
                // StaleElementReferenceException
                // NullPointerException

//                if (appSelenium.getSettingsOfTest().getLogSettings().isLogAction()) {
//                    // если нужно то логируем
//                    logger.info("[" + logTypeOfAction + " [Общ:" + Long.toString(waitingTimeMillis) +
//                            "Ост:" + Long.toString(waitingTimeMillisLeft) + "Инт:" + Long.toString(deltaToWaitMillis) +
//                            "] [\"" + seleniumElement.getElementFullName() + "\"] с XPath=" + seleniumElement.getElementFullXpath());      //---debug---
//                }

                // если еще нужно совершать действие
                if (waitingTimeMillisLeft < 0) {
                    // если оставшееся время меньше 0 то перестаем пытаться
                    // (условие в этом месте, что бы дать совершить последнее действие после истечения времени)
                    wait = false;
                    // создаем исключение для падения
                    if (isPrintStackTrace){
                        ex1.printStackTrace();
                    }
                    throw new TimeoutException();
                } else {
                    // вычисляем время
                    long currTime = System.nanoTime();
                    long pastedTime = (currTime - prevTime) / 1000000;
//                    long pastedTime = (currTime - prevTime);      //---debug---
//                    System.out.println("nano " + pastedTime);     //---debug---
//                    pastedTime = pastedTime / 1000;               //---debug---
//                    System.out.println("micro " + pastedTime);    //---debug---
//                    pastedTime = pastedTime / 1000;               //---debug---
//                    System.out.println("milli " + pastedTime);    //---debug---

                    if (pastedTime < deltaToWaitMillis) {
                        try {
                            Thread.sleep(deltaToWaitMillis - pastedTime);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }/*else {
//                            waitingTimeMillisLeft -= pastedTime;
                        }*/
                    currTime = System.nanoTime();
//                    System.out.println("Затраченое время: " + Long.toString(currTime - prevTime) + " нс.");      //---debug---
                    waitingTimeMillisLeft = waitingTimeMillis - (currTime - startTime) / 1000000;           // точнее
//                    System.out.println("Осталось времени на попытку: " + waitingTimeMillisLeft + " мс.");                   //---debug---
                    prevTime = currTime;
                }
            }
        }
        return returnParametr;
    }


}
