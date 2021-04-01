import { MINIMAL_VIEWPORTS } from '@storybook/addon-viewport';
import { addDecorator } from '@storybook/react';
import { withInfo } from '@storybook/addon-info';
import {withDesign} from 'storybook-addon-designs';

addDecorator(withInfo); 

export const parameters = {
  actions: { argTypesRegex: "^on[A-Z].*" },
  viewport: {
    viewports: MINIMAL_VIEWPORTS,
  },
};