package mocks;

import data.IrisScan;
import services.IrisScanner;

/**
 *
 * @author rav3
 */
public class ForbiddenIrisScanner implements IrisScanner {

    @Override
    public IrisScan scan() {
        throw new UnsupportedOperationException("Illegal Operation");
    }

}
