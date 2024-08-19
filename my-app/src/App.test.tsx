import { render, screen } from '@testing-library/react';
import DropdownComp from './Components/DropdownComp';

describe('App', () => {
  const options = [ { label: 'Janice Dsouza', value: 'ryjan0014' } ];
  
  test('renders DropdownComp component', () => {
    render(<DropdownComp options={options} />);
    const linkElement = screen.getByText('Select a player');
    expect(linkElement).toBeInTheDocument();
    expect(screen.getByText('Players')).toBeInTheDocument();
  });
});
